package Project_JSP.handler;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Banner;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BannerService;

public class AdminBannerHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			BannerService service = BannerService.getInstance();
			List<Banner> list = service.select();
			
			req.setAttribute("list", list);
			return filePath+"adminpage_banner.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return filePath+"adminpage_banner.jsp";
		}
		return filePath+"adminpage_banner.jsp";
	}

}
  