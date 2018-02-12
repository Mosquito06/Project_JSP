package Project_JSP.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Option;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.OptionDaoService;

public class ReservationStep2Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 서비스 목록 가져오기
		OptionDaoService optionService = OptionDaoService.getInstance();
		List<Option> optionResult = optionService.selectOption();
		HashMap<String, Object> result = new HashMap<>();
				
		if(optionResult != null){
			result.put("option", optionResult);
		}else if(optionResult == null || optionResult.get(0) == null){
			result.put("option", "false");
		}
		
		// 정보 가져오기
		int adultNum = Integer.parseInt(req.getParameter("adultNum"));
		int kidNum = Integer.parseInt(req.getParameter("kidNum"));
		int babyNum = Integer.parseInt(req.getParameter("babyNum"));
		int roomPrice = Integer.parseInt(req.getParameter("roomPrice"));
		String sDate = req.getParameter("sDate");
		String eDate = req.getParameter("eDate");
		
			// 숙박 일 계산
			SimpleDateFormat sm = new SimpleDateFormat("yyyyMMdd");
			Date ssDate = sm.parse(sDate);
			Date eeDate = sm.parse(eDate);
			long diff = eeDate.getTime() - ssDate.getTime();
			long stayDay = diff / (24 * 60 * 60 * 1000);
		
		
		String roomGrade = req.getParameter("roomGrade");
		String roomName = req.getParameter("roomName");
		String roomImg = req.getParameter("roomImg");
		String view = req.getParameter("view"); 
		String bed = req.getParameter("bed");
		
		result.put("adultNum", adultNum);
		result.put("kidNum", kidNum);
		result.put("babyNum", babyNum);
		result.put("sDate", sDate.substring(0, 4) + "." + sDate.substring(4, 6) + "." + sDate.substring(6, 8));
		result.put("eDate", eDate.substring(0, 4) + "." + eDate.substring(4, 6) + "." + eDate.substring(6, 8));
		result.put("stayDay", stayDay);
		result.put("roomGrade", roomGrade);
		result.put("roomName", roomName);
		result.put("roomPrice", roomPrice);
		result.put("roomImg", roomImg);
		result.put("view", view);
		result.put("bed", bed);
		
		req.setAttribute("result", result);
		
		return "/WEB-INF/view/reservation/step2.jsp";
			
	}

}
