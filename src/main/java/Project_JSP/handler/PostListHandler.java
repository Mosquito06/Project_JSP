package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Post;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.PostService;

public class PostListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String doro = "%"+req.getParameter("doro")+"%";
		PostService service = PostService.getInstance();
		List<Post> list =  service.selectPost(doro);
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(list);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
		pw.flush(); //고객에게 돌려줌
		return null;
	
	}

	 
}
