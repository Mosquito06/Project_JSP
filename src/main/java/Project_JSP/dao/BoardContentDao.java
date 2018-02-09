package Project_JSP.dao;

import Project_JSP.dto.BoardContent;

public interface BoardContentDao {
	public int insert(BoardContent content);
	public BoardContent findByNum(int boardNum);
	public int deletByNum(int boardNum);
	public int update(BoardContent content);
}
