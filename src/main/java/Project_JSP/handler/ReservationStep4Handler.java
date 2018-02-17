package Project_JSP.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;
import Project_JSP.dto.Room;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;
import Project_JSP.service.ReservationDaoService;
import Project_JSP.service.RoomDaoService;
import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class ReservationStep4Handler implements CommandHandler {
	HashMap<String, Object> result = new HashMap<>();
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		Client client = (Client) req.getSession().getAttribute("MEMBER");
		Client nonClient = null;
		
		if(client == null){
			String name = req.getParameter("name");
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			nonClient = new Client();
			
			nonClient.setNameKo(name);
			nonClient.setNameEn(firstName + " " + lastName);
			nonClient.setEmail(email);
			nonClient.setPhone(tel);
			nonClient.setClientGrade(ClientGrade.NONMEMBER);
			
			ClientDaoService.getInstance().insertClient(nonClient);
			Client selectNonClient = ClientDaoService.getInstance().selectNonClientByNameAndEmil(nonClient);
			setReservation(req, res, selectNonClient);
		}else{
			setReservation(req, res, client); 
		}
		
		return "/WEB-INF/view/reservation/step4.jsp";
			
	}
	
	public void setReservation(HttpServletRequest req, HttpServletResponse res, Client client){
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
	
		SimpleDateFormat sm = new SimpleDateFormat("yyyyMMdd");
		
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = sm.parse(checkIn.substring(0, 4)+checkIn.substring(5, 7)+checkIn.substring(8, 10));
			eDate = sm.parse(checkOut.substring(0, 4)+checkOut.substring(5, 7)+checkOut.substring(8, 10));
		} catch (ParseException e) {
			e.printStackTrace();
		} 

		int stay = Integer.parseInt(req.getParameter("stay").split("박")[0]);
		String stayNum = req.getParameter("stayNum");
		String roomInfo = req.getParameter("roomInfo");
		String[] splitInfo = roomInfo.split("/");
		String roomGrade = splitInfo[0].substring((splitInfo[0].indexOf("["))+1, splitInfo[0].lastIndexOf("]")).trim();
		String roomName = splitInfo[0].substring((splitInfo[0].indexOf("]"))+1).trim();
		String viewType = splitInfo[1].trim();
		String bedType = splitInfo[2].trim();

		String clientReq = req.getParameter("clientReq");
		String OptionName = req.getParameter("option");
		String optionContent = "";
		
		if(OptionName.equals("[]")){
			optionContent += "옵션을 선택하지 않았습니다.";
		}else{
			String[] splitOption = OptionName.split("]");
			
			
			for(int i = 0; i < splitOption.length; i++){
				String[] split1 = splitOption[i].split(",");
				if(i == 0){
					String[] split2 = split1[1].split("=");
					optionContent += split2[1] + " ";
					continue;
				}
				
				String[] split2 = split1[2].split("=");
				optionContent += split2[1] + " ";
			} 
		}
				
		String basicPrice = req.getParameter("basicPrice");
		String ServiceCharge = req.getParameter("ServiceCharge").split(" 원")[0];
		String Tax = req.getParameter("Tax").split(" 원")[0];
		String finalPrice = req.getParameter("finalPrice");
		
		RoomDaoService roomService = RoomDaoService.getInstance();
		List<Room> selectRoom = roomService.selectRoomToReservation(sDate, eDate, roomGrade, roomName, viewType, bedType);
		Reservation reservation = new Reservation();
		
		reservation.setCheckIn(sDate);
		reservation.setCheckOut(eDate);		
		reservation.setClientNum(client);
		reservation.setClientReq(clientReq);
		reservation.setOption(optionContent);
		reservation.setPayDate(new Date());
		reservation.setPersonnel(stayNum);
		reservation.setState(ReservationState.RESERVE);
		reservation.setTotalPrice(Integer.parseInt(finalPrice));
		reservation.setRoomNum(selectRoom.get(0));
		
		ReservationDaoService reservationService = ReservationDaoService.getInstance();
		
		reservationService.insertReservation(reservation);
		List<Reservation> ReservationList = reservationService.selectLastReservation();
		Reservation lastReservation = ReservationList.get(ReservationList.size()-1);
		Reservation selectReservation = reservationService.selectReservationNum(lastReservation);
				
		result.put("reservation", selectReservation);
		result.put("client", client);
		result.put("stay", stay);
		result.put("basicPrice", basicPrice);
		result.put("ServiceCharge", ServiceCharge);
		result.put("Tax", Tax);
		result.put("roomName", roomName);
		result.put("bedType", bedType);
		
		req.setAttribute("result", result);
	}

}
