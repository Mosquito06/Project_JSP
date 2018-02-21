package Project_JSP.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcUtil {
	
	public static void rollback(Connection conn){
		if(conn !=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
