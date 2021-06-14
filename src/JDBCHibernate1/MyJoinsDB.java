package JDBCHibernate1;

import java.sql.*;

public class MyJoinsDB {

    public static final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123456";

    public void getPhoneAddress() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select employees.phone_number as phone, personalinfo.address from employees, personalinfo\n" +
                            "where employees.idEmployee = personalinfo.idEmployee;");
            while (resultSet.next()) {
                String phone = resultSet.getString(1);
                String address = resultSet.getString(2);
                System.out.println("Phone: " + phone + "; Address: " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }
    }

    public void getNotMarriedEmployee() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select personalinfo.birthday, employees.phone_number \n" +
                        "from employees join personalinfo on employees.idEmployee = personalinfo.idEmployee \n" +
                        "where personalinfo.married = 0;");
            while (resultSet.next()) {
                Date birthday = resultSet.getDate(1);
                String phone = resultSet.getString(2);
                System.out.println("Date: " + birthday + "; Phone: " + phone);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }
    }

    public void getManagers() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select personalinfo.birthday, employees.phone_number from employees \n" +
                        "join personalinfo on employees.idEmployee = personalinfo.idEmployee\n" +
                        "join positions on employees.idPosition = positions.idPosition\n" +
                        "where positions.idPosition between 2 and 4;");
            while (resultSet.next()) {
                Date birthday = resultSet.getDate(1);
                String phone = resultSet.getString(2);
                System.out.println("Date: " + birthday + "; Phone: " + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }
    }

    private void closeConnections(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

/*    private static void registrationDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
