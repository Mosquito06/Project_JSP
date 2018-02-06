package Project_JSP.dto;

/**
 * @author DGIT3-9
 *
 */
public class BoardContent {
	private int num;
	private String content;
	
	public BoardContent(int num, String content) {
		this.num = num;
		this.content = content;
	}

	public BoardContent() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardContent [num=" + num + ", content=" + content + "]";
	}
	
	
}
