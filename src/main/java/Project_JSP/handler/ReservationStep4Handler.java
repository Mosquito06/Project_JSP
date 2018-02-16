package Project_JSP.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.dto.Option;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class ReservationStep4Handler implements CommandHandler {

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
			
		}else{
			setParameter(req, res); 
		}
		
		return null;
		// return "/WEB-INF/view/reservation/step4.jsp";
			
	}
	
	public void setParameter(HttpServletRequest req, HttpServletResponse res){
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
		int stay = Integer.parseInt(req.getParameter("stay").split("박")[0]);
		String stayNum = req.getParameter("stayNum");
		String roomInfo = req.getParameter("roomInfo");
		String clientReq = req.getParameter("clientReq");
		String OptionName = req.getParameter("option");
		String basicPrice = req.getParameter("basicPrice");
		String ServiceCharge = req.getParameter("ServiceCharge").split(" 원")[0];
		String Tax = req.getParameter("Tax").split(" 원")[0];
		String finalPrice = req.getParameter("finalPrice");
		
		System.out.println(checkIn);
		System.out.println(checkOut);
		System.out.println(stay);
		System.out.println(stayNum);
		System.out.println(roomInfo);
		System.out.println(clientReq);
		System.out.println(OptionName); 
		System.out.println(basicPrice);
		System.out.println(ServiceCharge);
		System.out.println(Tax);
		System.out.println(finalPrice);
		
	}

}
