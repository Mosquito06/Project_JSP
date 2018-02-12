package Project_JSP.dto;

public class Option {
	private int optionNum;
	private String optionContent;
	private int optionPrice;
	private SelectOption selectOption;

	public Option(String optionContent, int optionPrice, SelectOption selectOption) {
		super();
		this.optionContent = optionContent;
		this.optionPrice = optionPrice;
		this.selectOption = selectOption;
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

	public SelectOption getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(SelectOption selectOption) {
		this.selectOption = selectOption;
	}

	@Override
	public String toString() {
		return "Option [optionNum=" + optionNum + ", optionContent=" + optionContent + ", optionPrice=" + optionPrice
				+ ", selectOption=" + selectOption + "]";
	}

}
