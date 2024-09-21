package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "puki123";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();

//            String query = "SELECT * FROM phones";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String phoneNumber = resultSet.getString("phoneNumber");
//                String userName = resultSet.getString("userName");
//
//                System.out.println("ID: "+id+", phone number: "+phoneNumber+", user name: "+userName);
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close();

//        addPhone(connection,"+138124","Sib"); //adding phone into database
//        deletePhone(connection,5); //erasing pure evil from existence of database because of morals

        } catch (SQLException e) {
            System.out.println("Connection failure");
            throw new RuntimeException(e);
        }
    }

    public static void addPhone(Connection connection, String phoneNumber, String userName){
        try{
            Statement statement = connection.createStatement();
            String query = "INSERT INTO phones (phoneNumber,userName) VALUES ('"+phoneNumber+ "','" + userName +"')";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deletePhone(Connection connection, int id){
        try{
            Statement statement = connection.createStatement();
            String query = "DELETE FROM phones WHERE id = "+id;
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}