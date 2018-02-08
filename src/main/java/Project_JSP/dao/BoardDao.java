package Project_JSP.dao;

import java.util.HashMap;
import java.util.List;

import Project_JSP.dto.Board;

public interface BoardDao {
	public void insertBoard(Board board);
	public Board findByNumBoard(Board board);
	public List<Board> selcetAllBoard();
	public List<Board> findByNameBoard(Board board);
	public List<Board> findByTitleBoard(Board board);
	public List<Board> selcetAllLimitBoard(HashMap<String, Object> map);
	public List<Board> findByNameLimitBoard(HashMap<String, Object> map);
	public List<Board> findByTitleLimitBoard(HashMap<String, Object> map);
	public void deletByNumBoard(Board board);
	public void updateBoard(Board board);
}
