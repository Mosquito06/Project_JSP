package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.ClientDao;
import Project_JSP.dto.Client;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestClientDaoService {

	@Test
	public void selectacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			List<Client> list = dao.selectClient();

			for (Client f : list) {
				System.out.println(f.getNameKo());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

/*	@Test
	public void selectClientNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			Client client = new Client();
			client.setClientNum(1);
			Client selectClient = dao.selectClientNum(client);
			System.out.println(selectClient.getNameKo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
/*	@Test
	public void insertClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			
			Client client = new Client();
			client.setClientNum(12);
			client.setNameEn("비즈니스센터");
			
			
			dao.insertClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
	
/*	@Test
	public void updateClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			
			Client client = new Client();
			client.setClientNum(1);
			client.setHome("SDf");
			client.setId("Asd");
			dao.updateClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

/*	@Test
	public void deleteClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			
			Client client = new Client();
			client.setClientNum(1);
			
			dao.deleteClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
