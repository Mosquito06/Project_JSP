package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.QnaReply;

public interface QnaReplyDao {
	public List<QnaReply> selectAllQnaReply();
	public QnaReply findByNumQnaReply(QnaReply qnaReply);
	public void insertQnaReply(QnaReply qnaReply);
	public void deleteByNumQnaReply (QnaReply qnaReply);
	public void updateReply(QnaReply qnaReply);
	public QnaReply selectQnaReplyByNum(QnaReply qnaReply);
}
