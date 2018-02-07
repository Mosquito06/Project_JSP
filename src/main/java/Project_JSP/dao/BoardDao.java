package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Board;

public interface BoardDao {
	public void insertBoard(Board board);
	public Board findByNumBoard(Board board);
	public List<Board> selcetAllBoard();
	public List<Board> findByNameBoard(Board board);
	public void deletByNumBoard(Board board);
	public void updateBoard(Board board);
}
