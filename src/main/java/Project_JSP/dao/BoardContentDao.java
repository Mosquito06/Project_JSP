package Project_JSP.dao;

import Project_JSP.dto.BoardContent;

public interface BoardContentDao {
	public void insert(BoardContent content);
	public BoardContent findByNum(int boardNum);
	public void deletByNum(int boardNum);
	public void update(BoardContent content);
}
