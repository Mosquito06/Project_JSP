package Project_JSP.dao;

import Project_JSP.dto.QnaBoardContent;

public interface QnaBoardContentDao {
	public void insertQnaBoardContent(QnaBoardContent qnaContent);
	public QnaBoardContent selectQnaBoardByNum(QnaBoardContent qnaContent);
}
