package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.QnaView;

public interface QnaViewDao {
	public List<QnaView> selectQnaViewAll(QnaView qnaView);
	public List<QnaView> selectAll();
	public List<QnaView> selectNotNullQnaView();
	public List<QnaView> selectNullQnaView();
}
