package Project_JSP.mvc.util;

import java.io.File;

public class FileUtils {
	public static void deleteFile(String img, String uploadPath) {
		String deleteFileName = uploadPath + "\\" + img; 
		File deletefile = new File (deleteFileName);
		System.out.println("파일 삭제 진입" + deleteFileName);
		if(deletefile.exists() && deletefile.isFile()){
			System.out.println("파일 삭제 : " + img);
			deletefile.delete();
		}
	}
}
