package Project_JSP.handler;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Banner;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BannerService;

public class AdminBannerHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String set = req.getParameter("set");
			BannerService service = BannerService.getInstance();
			
			List<Banner> list = service.select();
			
			req.setAttribute("list", list);
			return filePath+"adminpage_banner.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String set = req.getParameter("set");
			BannerService service = BannerService.getInstance(); 
			
			if(set.equals("delete")){
				ObjectMapper om = new ObjectMapper(); 	
				
				String no = req.getParameter("no");
				int result = service.delete(new Banner(Integer.parseInt(no)));
				
				HashMap<String, Object> sendData = new HashMap<>();
				
				sendData.put("result", result);
				
				String json = om.writeValueAsString(sendData);
				
				res.setContentType("application/json;charset=utf-8");
				
                //PrintWrit == out과 같다.
				PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
				pw.print(json); //json pw에 넣기
				pw.flush(); //내보내기 
				
				return null;
			} 
			
			if(set.equals("insert")){
				ObjectMapper om = new ObjectMapper(); 	
				
				String imgPath = req.getParameter("imgPath");
				String linkPath = req.getParameter("linkPath");
				
				int result = service.insert(new Banner(0, linkPath, imgPath));
				
				HashMap<String, Object> sendData = new HashMap<>();
				if(result<0){
					sendData.put("error", "추가에 실패하였습니다.");
					return null;
				}
				
				int lastNo = service.getLastInsert();
				sendData.put("msg", "추가에 성공 하였습니다.");
				sendData.put("banner", new Banner(lastNo,imgPath,linkPath));
				
				String json = om.writeValueAsString(sendData);
				
				res.setContentType("application/json;charset=utf-8");
				
                //PrintWrit == out과 같다.
				PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
				pw.print(json); //json pw에 넣기
				pw.flush(); //내보내기 
				
				return null;
			} 
			return filePath+"adminpage_banner.jsp";
		}
		return filePath+"adminpage_banner.jsp";
	}

	
}
  