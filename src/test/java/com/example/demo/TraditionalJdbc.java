package com.example.demo;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

import java.sql.*;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-19 17:12
 */
public class TraditionalJdbc {

    @Test
    public static void main(String[] args) {
        String username = "root";
        String password = "123456";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/db_mybatis", username, password);
            String sql = "select * from user where username = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "admin");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("username")+" "+resultSet.getString("birthday"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
