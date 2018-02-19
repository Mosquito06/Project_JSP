package Project_JSP.dto;

public class QnaBoardContent {
	private int qnaNum;
	private String content;
	
	public int getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public QnaBoardContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaBoardContent(int qnaNum, String content) {
		super();
		this.qnaNum = qnaNum;
		this.content = content;
	}
	@Override
	public String toString() {
		return String.format("QnaBoardContent [qnaNum=%s, content=%s]", qnaNum, content);
	}
	
	
	
}