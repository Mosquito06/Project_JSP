package Project_JSP.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import Project_JSP.dto.Gallery;
import Project_JSP.dto.GalleryType;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.GalleryDaoService;

public class AdminGalleryHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return filePath + "adminpage_gallery.jsp";		
		}else if(req.getMethod().equalsIgnoreCase("post")){
			res.sendRedirect(postProcess(req, res, "/img/gallary"));
			return null;
		} 
		return filePath + "adminpage_gallery.jsp";
	}
	
	private String postProcess(HttpServletRequest req, HttpServletResponse res, String fileUploadPath) {
		String uploadPath = req.getRealPath(fileUploadPath);
		
		File dir = new File(uploadPath);
		if(dir.exists() == false){
			dir.mkdirs();//폴더만들기
		} 
		
		System.out.println("uploadPath - " + uploadPath);
		
		int maxSize = 1024 * 1024 * 10;//10M
		String fileName = "";
		String originFileName = ""; 
		try{
			Date now = new Date();
			MultipartRequest multi = new MultipartRequest(req, uploadPath,maxSize, "utf-8" , new DefaultFileRenamePolicy());
			
			HashMap<String, String> map = new HashMap<>();
			 
			fileName = multi.getFilesystemName("file");
			originFileName = multi.getOriginalFileName("file");
			
			String deleteFiles = multi.getParameter("deleteFiles");
			String uploadFiles = multi.getParameter("uploadFiles");
			String title = multi.getParameter("titleArr");
			String content = multi.getParameter("contentArr");
			String type = multi.getParameter("typeArr");
			deleteFiles = deleteFiles.replace(".jpg", "");
			deleteFiles = deleteFiles.replace(".png", "");
			deleteFiles = deleteFiles.replace(".gif", "");
			uploadFiles = uploadFiles.replace(".jpg", "");
			uploadFiles = uploadFiles.replace(".png", "");
			uploadFiles = uploadFiles.replace(".gif", "");
			
			String[] delteFileArr = null;
			  
			if(!deleteFiles.equals("")){
				delteFileArr =  deleteFiles.split(","); 
			}
			 
			String[] upLoadArr = uploadFiles.split(","); 
			String[] titleArr = title.split(","); 
			String[] contentArr =content.split(",");
			String[] typeArr = type.split(","); 
			File dirFile=new File(uploadPath);   
			File []fileList=dirFile.listFiles();
			List<String> uploadFileName = new ArrayList(); 
			
	    	System.out.println("======== 절취선 ========="); 
			for(File tempFile : fileList) {
			  if(tempFile.isFile()) {
			    String tempPath=tempFile.getParent();
			    String tempFileName=tempFile.getName();
			    
			    int compare = (int) (tempFile.lastModified()-now.getTime());
			    
			    if(compare>0&&compare<1000){
				    System.out.println("FileName="+tempFileName);
		    		if(delteFileArr != null){
		    			for(String delfile :delteFileArr){
							if(tempFileName.contains(delfile)){
					    		FileUtils.deleteFile(tempFileName, uploadPath);
					    		uploadFileName.remove(tempFileName);
					    	}else{
					    		uploadFileName.add(tempFileName);
					    	}
						} 
		    		}else{ 
		    			uploadFileName.add(tempFileName);  
		    		}
		    		
			    }
			  }      
			}
			
			map.put("fileName", fileName); 
			map.put("orignFileName", originFileName); 
			  
			req.setAttribute("file", map);		
			
			GalleryDaoService service = GalleryDaoService.getInstance();
			
			String contextPath = req.getContextPath() + fileUploadPath;
			
			for(int i=0; i<titleArr.length; i++){
				String upFile = "";
				
				for(String file : uploadFileName){
					if(file.contains(upLoadArr[i])){
						System.out.println("------"); 
						System.out.println(upLoadArr[i]);
						System.out.println(file);
						upFile = file;
						break;  
					}
				}  
				
				Gallery gallery = new Gallery(0, titleArr[i], contentArr[i],contextPath+"/"+upFile, galleryTypeCheck(typeArr[i]));
				service.insertGallery(gallery);  
			}
			
		}catch (Exception e){
			e.printStackTrace();
		} 
		
		return req.getContextPath() + "/adminGalleryList.do";
	}

	private GalleryType galleryTypeCheck(String typeArr) {
		int type = Integer.parseInt(typeArr);
		switch (type) {
		case 0:
			return GalleryType.ROOM;
		case 1:	
			return GalleryType.DINING;
		case 2:
			return GalleryType.ACTIVITY;
		case 3: 
			return GalleryType.FACILITY;
		case 4:
			return GalleryType.ETC;
		}
		return null;
	}
}
