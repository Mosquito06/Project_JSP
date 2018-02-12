package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.ClientDao;
import Project_JSP.dto.Client;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class ClientDaoService implements ClientDao {
	private static final ClientDaoService INSTANCE = new ClientDaoService();

	public static ClientDaoService getInstance() {
		return INSTANCE;
	}

	private ClientDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Client> selectClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClient();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client selectClientNum(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClientNum(client);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertClient(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			dao.insertClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateClient(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			dao.updateClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			dao.deleteClient(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client selectClientId(Client client) {
		
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClientId(client);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client selectClientPw(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClientPw(client);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client selectClientName(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClientName(client);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client selectClientEmail(Client client) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ClientDao dao = session.getMapper(ClientDao.class);
			return dao.selectClientEmail(client);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




}
