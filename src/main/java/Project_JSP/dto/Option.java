package Project_JSP.dto;

public class Option {
	private int optionNum;
	private String optionContent;
	private int optionPrice;

	public Option(String optionContent, int optionPrice) {
		super();
		this.optionContent = optionContent;
		this.optionPrice = optionPrice;
	}

	public Option() {
		// TODO Auto-generated constructor stub
	}

	public int getOptionNum() {
		return optionNum;
	}

	public void setOptionNum(int optionNum) {
		this.optionNum = optionNum;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}

}
