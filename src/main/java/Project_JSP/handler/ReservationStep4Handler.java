package Project_JSP.handler;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
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
			
			int RanNum = (int) (Math.floor(Math.random()*10000)+1);
			String id = "DGSHILLA" + RanNum;
			
			List<Client> clientList = ClientDaoService.getInstance().selectClient();
			for(Client c : clientList){
				if(c.getId().equals(id)){
					 RanNum = (int) (Math.floor(Math.random()*10000)+1);
					 id = "DGSHILLA" + RanNum;
				}
			}
						
			nonClient.setId(id);
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
		if(clientReq == "" || clientReq == null){
			clientReq = "요청사항 없음";
		}
		
		String OptionName = req.getParameter("option");
		String optionContent = "";
		
		if(OptionName.equals("[]")){
			optionContent += "선택 옵션 없음";
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
		
		SendEmail(client,reservation,checkIn,checkOut,roomInfo,basicPrice,ServiceCharge,Tax);
		req.setAttribute("result", result);
	}
	
	private void SendEmail(Client to, Reservation reservation,String checkIn,String checkOut,String roomInfo,String  basicPrice,String ServiceCharge , String Tax){
		
		 String host = "smtp.naver.com";
		String user = "rkd7327";
		String password = "rkdgus0519";
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getEmail()));

			String subject = "신라리워즈 예약내역 발송메일입니다.";
			try {
				message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String Meg = "<div style='width:700px;background-color:#f1e3c4;margin:0 auto; padding:0;font:12px/160% Dotum,돋움,serif; color:#101010;overflow:hidden;'>"
					+ "<div style='height:70px;text-align:center;'>"
						+ "<h1 style='margin:0px; padding:25px 0 0 0;'>"
						+ "<a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/index.jsp'>"
						+ "<img style='border:0;' src='http://www.shillahotels.com/images/ko/common/email/rewards/hLogo.gif' alt=''>"
						+ "</a></h1></div>"
						
						+ "<img style='border:0; vertical-align:middle' src='http://www.shillahotels.com/images/ko/common/email/rewards/mainImg2.jpg' alt='신라리워즈 이미지'>"
						
						+ "<div style='float:left; width:680px; background:#FFF; min-height:100px; margin:0 10px; padding:0; padding-bottom:10px;'>"
							+ "<div style='margin:30px;line-height:200%'>"
							+ "<p style='margin:0; padding:0;color:#666;'>안녕하십니까. 신라리워즈입니다. </p>"
							+ "<p style='margin:0; padding:0;color:#666;'>"+to.getNameEn()+"님의 예약내역 안내해 드립니다.</p>"
							+ "</div>"
							
							+ "<div style='background-color:#f9f7f4;border-top:1px solid #edeae6;border-bottom:1px solid #edeae6;padding:10px 0 5px 0;'>"
								+ "<div style='margin:10px 30px 0 30px;'>"
									+ "<p style='color:#333;'>아래의 예약내역을 확인해 주시기 바랍니다.</p>"
									+ "<div style='margin:10px;'>"
									+ "<table style='width:100%;'>"
										+ "<tr style='height:60px; line-height:60px; font-size:15px;'>"
											+ "<th>예약번호</th>"
											+ "<td colspan='5'>"+to.getId()+"</td>"
										+ "</tr>"
										+"<tr style='height:40px; line-height:40px;'>"
											+ "<th style='color:#a0886e;  border-top:1px dotted black;'>체크인</th>"
											+ "<td colspan='2' style=' border-top:1px dotted black;'>"+checkIn+"</td>"
											+ "<th style='color:#a0886e;border-top:1px dotted black;'>체크아웃</th>"
											+ "<td colspan='2' style=' border-top:1px dotted black;'>"+checkOut+"</td>"
										+ "</tr>"
										+ "<tr style='height:40px; line-height:40px;'>"
											+ "<th style='color:#a0886e;'>숙박일수</th>"
											+ "<td colspan='2'>숙박일수가 들어가는 자리</td>"
											+ "<th style='color:#a0886e;'>숙박인원</th>"
											+ "<td colspan='2'>"+reservation.getPersonnel()+"</td>"
										+ "</tr>"
										+ "<tr style='height:40px; line-height:40px;'>"
											+ "<th style='color:#a0886e;'>객실</th>"
											+ "<td colspan='2'>"+roomInfo+"</td>"
											+ "<th style='color:#a0886e;'>기본요금</th>"
											+ "<td colspan='2'>"+basicPrice+"</td>"
										+ "</tr>"
										+ "<tr style='height:40px; line-height:40px;'>"
											+ "<th style='color:#a0886e;'>봉사료</th>"
											+ "<td  colspan='2'>"+ServiceCharge+"</td>"
											+ "<th style='color:#a0886e;'>세금</th>"
											+ "<td  colspan='2'>"+Tax+"</td>"
										+ "</tr>"
										+ "<tr style='height:60px; line-height:60px; font-size:15px;'>"
											+ "<th style=' border-top:1px dotted black;'>요금 합계</th>"
											+ "<td colspan='5' style=' border-top:1px dotted black;'>"+reservation.getTotalPrice()+"</td>"
										+ "</tr>"
										+ "</table></div></div></div>"
										+ "<p style='color:#666; margin:10px 20px;'>상세한 정보는 홈페이지에서 확인할 수 있습니다.</p>"
										+ "<p style='color:#666; margin:5px 5px 20px 20px;'>좋은 서비스로 고객님께 다가가겠습니다.</p>"
										+ "<p style='font-size:20px; text-align:center;'>저희 신라호텔을 이용해주셔서 감사합니다.</p>"
										+ "</div>"
										
										+ "<div style='width:700px;'>"
										+ "<div style=' background:#f1e3c4; float:left; overflow:hidden;padding:20px 40px; width:620px;'>"
											+ "<div style='float:left;width:134px;'>"
											+ "<h2 style='margin:20px 0;'><a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/login.do'><img style='border:0;' src='http://www.shillahotels.com/images/ko/common/email/theShilla/fLogo.gif' alt=''></a></h2>"
											+ "</div>"
											
											+ "<div style='float:right;width:465px;margin-top:15px;'>"
											+ "<p style='color:#3e2b2c;font-size:11px; '>본 메일은 발신전용 메일입니다."
											+ "궁금하신 점은 <a style='text-decoration:none; color:#555' target='_blank' href='hotels.com/membership/inquires/contactus/memIndex.do?lang=ko'>Contact Us</a>로 문의해주시기 바랍니다.</p>"
											+ "</div></div>"
											
											+ "<div style='float:left; background-color:#3e2b2c;padding:10px 0;text-align:center;width:100%;'>"
											+ "<p style='font-size:10px;color:#ab9899;'>Copyright © HOTEL SHILLA CO LTD. All Rights Reserved. 신라리워즈 : TEL +82-2-2230-5528</p>"
											+ "</div></div>";
			message.setText(Meg,"UTF-8");
			message.setHeader("content-Type", "text/html");
			
			Transport.send(message);
			System.out.println("전송성공");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
