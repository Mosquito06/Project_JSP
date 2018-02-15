package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.BannerDao;
import Project_JSP.dto.Banner;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class BannerService {
	private final static BannerService instance = new BannerService();
	
	public static BannerService getInstance() {
		return instance;
	}
	  
	public List<Banner> select(){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BannerDao dao = session.getMapper(BannerDao.class);
			 
			return dao.select(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	};
	public Banner selectByNo(Banner banner){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BannerDao dao = session.getMapper(BannerDao.class);
			
			return dao.selectByNo(banner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;		
	};
	public int insert(Banner banner){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BannerDao dao = session.getMapper(BannerDao.class);
			
			return dao.insert(banner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	};
	public int update(Banner banner){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BannerDao dao = session.getMapper(BannerDao.class);
			
			return dao.update(banner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	};
	public int delete(Banner banner){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BannerDao dao = session.getMapper(BannerDao.class);
			
			return dao.delete(banner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	};
}
