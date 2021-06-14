package JDBCHibernate2;

import JDBCHibernate2.dao.CarDAO;
import JDBCHibernate2.dao.ClientDAO;
import JDBCHibernate2.dao.DAOFactory;
import JDBCHibernate2.dao.IDAOFactory;
import JDBCHibernate2.entity.Client;

public class Main {

    public static void main(String[] args) {

        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();

        //---getAllClient---
        for (Client clientLoop : clientDAO.getAllClients()) {
            System.out.println(clientLoop);
        }

        //---addClient---
        Client client = new Client();
        client.setName("Jacob");
        client.setAge(20);
        client.setPhone("103");
        clientDAO.addClient(client);

        //---updateClient age by ID
        clientDAO.updateClient(30, 1);

        //---getClient by ID---
        System.out.println(clientDAO.getClient(1));

        //---deleteClient by ID
        clientDAO.deleteClient(3);

        //---getAllClient---
        for (Client clientLoop : clientDAO.getAllClients()) {
            System.out.println(clientLoop);
        }


    }

}
