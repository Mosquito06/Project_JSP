package Project_JSP.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Gallery;
import Project_JSP.dto.GalleryType;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.GalleryDaoService;

public class GalleryPhotoListHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/gallary/";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		GalleryDaoService service = GalleryDaoService.getInstance();

	    String galType = req.getParameter("showGalType");
	    List<Gallery> list = null;
	    
	    switch(galType){
	    	case "ALL":
		    	list = service.selectGallery();
	    	break;
	    	case "ROOM":
	    		list = service.selectByGalleryType(new Gallery(GalleryType.ROOM));
	    	break;

	    	case "DINING":
	    		list = service.selectByGalleryType(new Gallery(GalleryType.DINING));
	    	break;

	    	case "ACTIVITY":
	    		list = service.selectByGalleryType(new Gallery(GalleryType.ACTIVITY));
	    	break;
	    	
	    	case "RETREAT":
	    		list = service.selectByGalleryType(new Gallery(GalleryType.FACILITY));
	    	break;

	    	case "ETC":
	    		list = service.selectByGalleryType(new Gallery(GalleryType.ETC));
	    	break;
	    	default:
	    		list = service.selectGallery();
	    	break;
	    }
	    if(galType.equals("ALL")){  
	    }else  if(galType == "ROOM"){
	    	list = service.selectGallery();  	
	    }else  if(galType == "DINING"){
	    	list = service.selectGallery();
	    }else  if(galType == "ACTIVITY"){
	    	list = service.selectGallery();
	    }else  if(galType == "RETREAT"){ 
	    	list = service.selectGallery();
	    }else  if(galType == "ETC"){
	    	list = service.selectGallery(); 
	    }  
 
    	System.out.println(list);
		req.setAttribute("list", list);
	     
		return filePath + "photoList.jsp"; 
	}
	
}
  