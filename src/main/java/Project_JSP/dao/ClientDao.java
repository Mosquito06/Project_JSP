package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Client;



public interface ClientDao {
	public List<Client> selectClient();
	public Client selectClientNum(Client client);
	public void insertClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(Client client);
	public Client selectClientId(Client client);
	public Client selectClientPw(Client client);
	public Client selectClientName(Client client);
	public Client selectClientEmail(Client client);
	public Client findClientId(Client client);
	public void updateProfile(Client client);
}
