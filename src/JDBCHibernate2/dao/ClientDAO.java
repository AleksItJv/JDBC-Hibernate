package JDBCHibernate2.dao;

import JDBCHibernate2.entity.Client;

import java.util.List;

public interface ClientDAO {

    void addClient(Client client);

    Client getClient(int id);

    List<Client> getAllClients();

    void updateClient(int age, int id);

    void deleteClient(int id);
}
