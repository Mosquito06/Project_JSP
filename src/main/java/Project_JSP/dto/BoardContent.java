package Project_JSP.dto;

/**
 * @author DGIT3-9
 *
 */
public class BoardContent {
	private Board num;
	private String content;

	public Board getNum() {
		return num;
	}

	public void setNum(Board num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BoardContent(Board num, String content) {
		super();
		this.num = num;
		this.content = content;
	}

	public BoardContent() {
		// TODO Auto-generated constructor stub
	}

}