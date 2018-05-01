package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.QnaView;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaViewService;

public class QnaCommendHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			
			QnaView view = new QnaView();
			view.setId(req.getParameter("id"));
			
			QnaViewService service =QnaViewService.getInstance();
			List<QnaView> list = service.selectNullQnaViewById(view);
			
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(list);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush(); //고객에게 돌려줌
			return null;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			QnaView view = new QnaView();
			view.setId(req.getParameter("id"));
			
			QnaViewService service =QnaViewService.getInstance();
			List<QnaView> list = service.selectNotNullQnaViewById(view);
			
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(list);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush(); //고객에게 돌려줌
			return null;
		}
		return null;
	}

}
