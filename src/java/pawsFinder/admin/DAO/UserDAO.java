/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pawsFinder.admin.model.Dog;
import pawsFinder.admin.model.User;

/**
 *
 * @author user
 */
public class UserDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/pawsfinder";
    private String jdbcUsername="root";
    private String jdbcPassword="";
    
    private static final String VIEW_ALL_USERS="SELECT userID,firstName,lastName,userEmailID,userPhone,userPostalCode,userCity,TIMESTAMPDIFF(year,userDOB,curdate()) as age FROM usertbl;";
    private static final String DELETE_USERS_SQL= "DELETE FROM usertbl where userID = ?;";
    
    protected Connection jdbcConnection= null;
    
    protected Connection getConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return jdbcConnection;
    }
    
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public List<User> viewAllUsers()
    {
        List<User> users = new ArrayList<>();
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(VIEW_ALL_USERS);)
        {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                int userID = resultSet.getInt("userID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String userEmailID = resultSet.getString("userEmailID");
                long userPhone = resultSet.getLong("userPhone");
                int userPostalCode = resultSet.getInt("userPostalCode");
                String userCity = resultSet.getString("userCity");
             
                users.add(new User(userID, firstName, lastName, userEmailID, userPhone, userPostalCode, userCity, age));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean deleteUser(int id) throws SQLException{
        boolean rowDeleted = false;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(DELETE_USERS_SQL);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}