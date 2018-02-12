package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Comment;

public interface CommentDao {
	public List<Comment> selcetAllComment();
	public List<Comment>  findByNumComment(Comment comment);
	public int insertComment(Comment comment);
	public int deletByNumComment(Comment comment);
	public int updateComment(Comment comment);
}
