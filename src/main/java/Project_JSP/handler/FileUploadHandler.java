package Project_JSP.handler;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.management.VMOption.Origin;

import Project_JSP.mvc.controller.CommandHandler;

public class FileUploadHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/event/";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("get")){
			return filePath + "fileUpload.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			return postProcess(req,res);
		}
		return null;
	}
	
	private String postProcess(HttpServletRequest req, HttpServletResponse res) {
		String uploadPath = req.getRealPath("/img/event");
		
		File dir = new File(uploadPath);
		if(dir.exists() == false){
			dir.mkdirs();//폴더만들기
		}
		
		System.out.println("uploadPath - " + uploadPath);
		
		int maxSize = 1024 * 1024 * 10;//10M
		String fileName = "";
		String originFileName = "";
		try{
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath,maxSize, "utf-8" , new DefaultFileRenamePolicy());
			
			HashMap<String, String> map = new HashMap<>();
			
			fileName = multi.getFilesystemName("upload");
			originFileName = multi.getOriginalFileName("upload");
			
			map.put("fileName", fileName);
			map.put("orignFileName", originFileName);
			
			req.setAttribute("file", map);		
			
			String contextPath = req.getContextPath() + "/img/event";
					
			String uploadScript= "<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(1,'"+contextPath+ "/" + fileName + "', '완료');</script>";
			
			req.setAttribute("upScript", uploadScript);
						
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return filePath + "fileUpload.jsp";
	}

}
 