package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Option;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.OptionDaoService;

public class ReservationStep2Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		OptionDaoService optionService = OptionDaoService.getInstance();
		List<Option> optionResult = optionService.selectOption();
		
		if(optionResult != null){
			req.setAttribute("option", optionResult);
		}else if(optionResult == null || optionResult.get(0) == null){
			req.setAttribute("option", "false");
		}
		
		
		return "/WEB-INF/view/reservation/step2.jsp";
			
	}

}
