package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.PostDao;
import Project_JSP.dto.Post;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class PostService implements PostDao{
	private static final PostService instance = new PostService();

	public static PostService getInstance() {
		return instance;
	}

	private PostService(){}

	@Override
	public List<Post> selectPost(String doro) {
		
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			PostDao dao = session.getMapper(PostDao.class);
			return dao.selectPost(doro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
