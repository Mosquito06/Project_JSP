package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Banner;

public interface BannerDao {
	public List<Banner> select();
	public Banner selectByNo(Banner banner);
	public int insert(Banner banner);
	public int update(Banner banner);
	public int delete(Banner banner);
}
 