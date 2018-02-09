package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Post;

public interface PostDao {
	public List<Post> selectPost(String doro); 
}
