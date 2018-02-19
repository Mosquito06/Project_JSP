package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.QnaBoard;

public interface QnaBoardDao {
	public void insertQnaBoard(QnaBoard qnaBoard);
	public List<QnaBoard> selectAllQnaBoard();
	public QnaBoard selectByNumQnaBoard(QnaBoard qnaBoard); 
	public void deleteByNumQnaBoard(QnaBoard qnaBoard);
	public int lastId();
}
