package main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/z0806", "student", "123")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person left join department d on dept_id = d.id");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String department = resultSet.getString("title");
                System.out.println(name + " " + age + " " + phone + " " + department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
