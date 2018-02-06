package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Option;

public interface OptionDao {
	public List<Option> selectOption();
	public Option selectOptionNum(Option option);
	public void insertOption(Option option);
	public void updateOption(Option option);
	public void deleteOption(Option option);
}
