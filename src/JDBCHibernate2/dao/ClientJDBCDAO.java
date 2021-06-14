package JDBCHibernate2.dao;

import JDBCHibernate2.connection.Connector;
import JDBCHibernate2.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDAO implements ClientDAO {

    @Override
    public void addClient(Client client) {
        Connection connection = Connector.getConnection();
        PreparedStatement preStatement = null;

        try {
            preStatement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");
            preStatement.setString(1, client.getName());
            preStatement.setInt(2, client.getAge());
            preStatement.setString(3, client.getPhone());
            preStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preStatement);
        }
    }

    @Override
    public Client getClient(int id) {
        Client client = new Client();
        Connection connection = Connector.getConnection();
        PreparedStatement preStatement = null;

        try {
            preStatement = connection.prepareStatement("SELECT * FROM clients WHERE clients.id = ?");
            preStatement.setInt(1, id);
            preStatement.execute();

            ResultSet rs = preStatement.executeQuery();
            rs.next();
            client.setId(id);
            client.setName(rs.getString(2));
            client.setAge(rs.getInt(3));
            client.setPhone(rs.getString(4));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preStatement);
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        Client client;
        Connection connection = Connector.getConnection();
        PreparedStatement preStatement = null;

        try {
            preStatement = connection.prepareStatement("SELECT * FROM clients");
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setAge(rs.getInt(3));
                client.setPhone(rs.getString(4));
                clientList.add(client);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preStatement);
        }

        return clientList;
    }

    @Override
    public void updateClient(int age, int id) {
        Connection connection = Connector.getConnection();
        PreparedStatement preStatement = null;

        try {
            preStatement = connection.prepareStatement("UPDATE clients SET clients.age = ? WHERE clients.id = ?");
            preStatement.setInt(1, age);
            preStatement.setInt(2, id);

            int res = preStatement.executeUpdate();
            System.out.println(res);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preStatement);
        }

    }

    @Override
    public void deleteClient(int id) {
        Connection connection = Connector.getConnection();
        PreparedStatement preStatement = null;

        try {
            preStatement = connection.prepareStatement("DELETE FROM clients WHERE clients.id = ?");
            preStatement.setInt(1, id);

            int res = preStatement.executeUpdate();
            System.out.println(res);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preStatement);
        }
    }

    private void closeConnections(Connection connection, PreparedStatement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
