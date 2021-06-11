package JDBCHibernate1;

import java.sql.*;

public class MyJoinsDB {

    public static final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123456";

    public void getPhoneAddress() {
        registrationDriver();

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

    private static void registrationDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
