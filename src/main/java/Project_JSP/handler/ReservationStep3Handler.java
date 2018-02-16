package Project_JSP.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Option;
import Project_JSP.mvc.controller.CommandHandler;

public class ReservationStep3Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Option> selectOption = new ArrayList<>();
		HashMap<String, Object> result = new HashMap<>();
		
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
		int stay = Integer.parseInt(req.getParameter("stay").split("박")[0]);
		String stayNum = req.getParameter("stayNum");
		String roomInfo = req.getParameter("roomInfo");
		String bedType = roomInfo.split("/")[2];
		String clientReq = req.getParameter("clientReq");
		String roomImg = req.getParameter("roomImg");
		String OptionName = req.getParameter("Option");
		String basicPrice = req.getParameter("basicPrice");
		String ServiceCharge = req.getParameter("ServiceCharge");
		String Tax = req.getParameter("Tax");
		String finalPrice = req.getParameter("finalPrice");
		
		if(OptionName == ""){
			result.put("option", "false"); 
		}else{
			String[] OptionString = OptionName.split("/");
			
			for(int i = 0; i < OptionString.length; i++){
				Option o = new Option();
				o.setOptionContent(OptionString[i].split(",")[0]);
				o.setOptionPrice(Integer.parseInt(OptionString[i].split(",")[1]));
				selectOption.add(o);
			}
		}
		
		result.put("checkIn", checkIn);
		result.put("checkOut", checkOut);
		result.put("stay", stay);
		result.put("stayNum", stayNum);
		result.put("roomInfo", roomInfo);
		result.put("bedType", bedType);
		result.put("clientReq", clientReq);
		result.put("roomImg", roomImg);
		result.put("ServiceCharge", ServiceCharge);
		result.put("Tax", Tax);
		result.put("basicPrice", basicPrice);
		result.put("finalPrice", finalPrice);
		result.put("option", selectOption);	
		
		req.setAttribute("result", result);
		
		return "/WEB-INF/view/reservation/step3.jsp";
			
	}

}
