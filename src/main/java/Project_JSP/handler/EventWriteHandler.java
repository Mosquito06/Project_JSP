package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.Event;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.EventService;

public class EventWriteHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/event/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return filePath + "eventWrite.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return postProcess(req, res);
		}
		return null;
	}

	private String postProcess(HttpServletRequest req, HttpServletResponse res) {
		String uploadPath = req.getRealPath("/img/event");
		String contextPath = "";

		File dir = new File(uploadPath);
		if (dir.exists() == false) {
			dir.mkdirs();// 폴더만들기
		}

		System.out.println("uploadPath - " + uploadPath);

		int maxSize = 1024 * 1024 * 10;// 10M
		String fileName = "";
		String originFileName = "";
		try {

			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			HashMap<String, String> map = new HashMap<>();
			
			contextPath = req.getContextPath() + "/img/event";
			
			fileName = multi.getFilesystemName("imgpath");
			originFileName = multi.getOriginalFileName("imgpath");

			map.put("fileName", fileName);
			map.put("orignFileName", originFileName);
			
			
			String title = multi.getParameter("title");
			String startDate = multi.getParameter("startDate");
			String endDate = multi.getParameter("endDate");
			String content = multi.getParameter("hiddenContent");
			String introduce = multi.getParameter("introduce");

			EventService service = EventService.getInstance();

			Event event = new Event();
			event.setEventTitle(title);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			event.setEventStartDay(format.parse(startDate));
			event.setEventEndDay(format.parse(endDate));
			event.setEventIntroduce(introduce);
			event.setEventImgPath(contextPath + "/" + fileName);

			int result = service.insertEvent(event, content);

			if (result < 0) {
				req.setAttribute("error", "글쓰기에 실패하였습니다.");
				res.sendRedirect(filePath + "eventWrite.jsp");
				return null;
			}

			res.sendRedirect(req.getContextPath() + "/event/evnetlist.do");
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
