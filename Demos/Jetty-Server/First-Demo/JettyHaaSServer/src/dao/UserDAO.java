/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DatabaseConnection;
import pojo.Medicine;
import pojo.User;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shall
 */
public class UserDAO {

    Connection databaseConnection;

    public UserDAO() {
        databaseConnection = DatabaseConnection.initDatabaseConnection();
    }

    public boolean AddUser(User user) {
        if (isUserExist(user.getEmail())) { // it means user exists with the same email in the system
            return false;
        } else {
            String query = "insert into users (email,password) values(?,?)";
            try {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());

                int result = preparedStatement.executeUpdate();
                System.out.println(result);
                if (result > 0) {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("success adding User");
                    return true;
                } else {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("failed to add User");
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public boolean deleteAllUsers() {
        ArrayList<User> users = getAllUsers();
        if (users.isEmpty()) {
            return true;
        } else {

            PreparedStatement preparedStatement;
            try {
                String query = "DELETE FROM users ";
                preparedStatement = databaseConnection.prepareStatement(query);

                int rowsNum = preparedStatement.executeUpdate();

                if (rowsNum > 0) {
                    System.out.println(rowsNum + " Users deleted");
                    return true;
                } else {
                    System.out.println("Couldn't delete Users");
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateUser(User user) {

        String query = "UPDATE users SET email=?, password=?  where user_id =? ";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserId());

            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            if (result > 0) {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("success updating User");
                return true;
            } else {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("failed to update User");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "select * from users";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            System.out.println("Number of users: " + users.size());
            preparedStatement.close();
            //databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean isUserExist(String email) {
        String query = "select * from users where email=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("User Already Exists");
                return true;

            } else {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("User Doesn't Exist");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(String email) {
        User user = new User();
        String query = "select * from users where email=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

            }
            preparedStatement.close();
            //databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean loginUser(User user) {
        String query = "select * from users where email=? and password=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                preparedStatement.close();
                return true;

            } else {
                preparedStatement.close();
                return false;
            }

            //databaseConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
