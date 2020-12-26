/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import pawsFinder.admin.model.AdoptionRequest;
import pawsFinder.admin.model.Dog;

/**
 *
 * @author user
 */

//This class has all the JDBC related stuff
//DAO is a design pattern to seperate out all the database related stuff into a seperate class.

public class DogDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/pawsfinder";
    private String jdbcUsername="root";
    private String jdbcPassword="";
    
    private final String UPLOAD_DIRECTORY = "E:/DAIICT";
    
    private static final String INSERT_DOGS_SQL="insert into dogtbl(dogName,dogAge,dogSize,gender,breed,color,city,description,friendly,price) values"+ "(?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_DOG_BY_ID="select dogName,dogAge,dogSize,gender,breed,color,city,description,adoptionStatus,friendly,price from dogtbl where dogID=?;";
    private static final String VIEW_ALL_DOGS="SELECT dogID,dogName,dogAge,dogSize,gender,breed,color,city,description,adoptionStatus,friendly,price FROM dogtbl;";
    private static final String DELETE_DOGS_SQL= "DELETE FROM dogtbl where dogID = ?;";
    private static final String UPDATE_DOGS_SQL= "UPDATE dogtbl SET dogName = ?, dogAge = ?, dogSize = ?, gender = ?, breed = ?, color = ?, city = ?, description = ?, adoptionStatus = ?, friendly = ?, price = ? WHERE dogID=?;";
    private static final String UPDATE_STATUS_SQL= "UPDATE dogtbl SET adoptionStatus = ? WHERE dogID=?;";
    private static final String INSERT_IMAGE_SQL = "insert into dogimages(dogID,imagePath) values"+ "(?,?);";
    private static final String VIEW_ALL_ADOPTION_REQUESTS="SELECT adoptionrequest.requestID, dogtbl.dogName, usertbl.firstName, dogtbl.adoptionStatus,dogtbl.price,adoptionrequest.status FROM ((adoptionrequest INNER JOIN dogtbl ON adoptionrequest.dogID = dogtbl.dogID) INNER JOIN usertbl ON adoptionrequest.userID = usertbl.userID)";
    
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
    
    //CREAT OR INSERT DOG
    public void insertDog(Dog dog) throws SQLException {
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(INSERT_DOGS_SQL);)
        {
            System.out.println("insertDog");
            statement.setString(1, dog.getDogName());
            statement.setInt(2, dog.getDogAge());
            statement.setString(3, dog.getDogSize());
            statement.setString(4, dog.getGender());
            statement.setString(5, dog.getBreed());
            statement.setString(6, dog.getColor());
            statement.setString(7, dog.getCity());
            statement.setString(8, dog.getDescription());
            statement.setString(9, dog.getFriendly());
            statement.setFloat(10, dog.getPrice());
            statement.executeUpdate();
            statement.close();
            disconnect();
            
        }
        catch(Exception e)
        {
            System.out.println("error Message "+ e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public int getID() throws SQLException{
        String query = "select MAX(dogID) from dogtbl;";
        int dogID=0;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(query);)
            {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next())
                {
                    dogID= resultSet.getInt("dogID");
                }
                statement.close();
                disconnect();
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return dogID;
    }
    
    //UPDATE DOG
    public boolean updateDog(Dog dog) throws SQLException {
        boolean rowUpdated = false;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(UPDATE_DOGS_SQL);)
        {
            statement.setString(1, dog.getDogName());
            statement.setInt(2, dog.getDogAge());
            statement.setString(3, dog.getDogSize());
            statement.setString(4, dog.getGender());
            statement.setString(5, dog.getBreed());
            statement.setString(6, dog.getColor());
            statement.setString(7, dog.getCity());
            statement.setString(8, dog.getDescription());
            statement.setString(9, dog.getAdoptionStatus());
            statement.setString(10, dog.getFriendly());
            statement.setFloat(11, dog.getPrice());
            statement.setInt(12,dog.getDogID());
            
            rowUpdated  = statement.executeUpdate()>0;
            statement.close();
            disconnect();
            return rowUpdated;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rowUpdated;  
    }
    
    //UPDATE ADOPTION STATUS
    public boolean updateStatus(Dog dog) throws SQLException {
        boolean rowUpdated = false;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(UPDATE_STATUS_SQL);)
            {
                statement.setString(1, dog.getAdoptionStatus());
                statement.setInt(2,dog.getDogID());
                rowUpdated  = statement.executeUpdate()>0;
                statement.close();
                disconnect();
                return rowUpdated;
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rowUpdated;  
    }
    
    //SELECT DOG BY ID
    public Dog selectDog(int dogID)
    {
        Dog dog = null;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(SELECT_DOG_BY_ID);)
        {
            statement.setInt(1, dogID);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                String dogName = resultSet.getString("dogName");
                int  dogAge= resultSet.getInt("dogAge");
                String dogSize = resultSet.getString("dogSize");
                String gender = resultSet.getString("gender");
                String breed = resultSet.getString("breed");
                String color = resultSet.getString("color");
                String city = resultSet.getString("city");
                String description = resultSet.getString("description");
                String adoptionStatus = resultSet.getString("adoptionStatus");
                String friendly = resultSet.getString("friendly");
                float price = resultSet.getFloat("price");
             
                dog = new Dog(dogID, dogName, dogAge, dogSize, gender, breed, color, city, description, adoptionStatus, friendly, price);
            }
        }
        catch(SQLException e)
        {System.out.println("error message:" + e.getMessage());
            e.printStackTrace();
        }
        return dog;
    }
    
    //VIEW ALL DOGS
    public List<Dog> viewAllDogs()
    {
        List<Dog> dogs = new ArrayList<>();
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(VIEW_ALL_DOGS);)
        {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                int dogID = resultSet.getInt("dogID");
                String dogName = resultSet.getString("dogName");
                int  dogAge= resultSet.getInt("dogAge");
                String dogSize = resultSet.getString("dogSize");
                String gender = resultSet.getString("gender");
                String breed = resultSet.getString("breed");
                String color = resultSet.getString("color");
                String city = resultSet.getString("city");
                String description = resultSet.getString("description");
                String adoptionStatus = resultSet.getString("adoptionStatus");
                String friendly = resultSet.getString("friendly");
                float price = resultSet.getFloat("price");
             
                dogs.add(new Dog(dogID, dogName, dogAge, dogSize, gender, breed, color, city, description, adoptionStatus, friendly, price));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return dogs;
    }

    //DELETE DOG
    public boolean deleteDog(int id) throws SQLException{
        boolean rowDeleted = false;
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(DELETE_DOGS_SQL);)
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
    
    public void insertImage(ArrayList<String> paths, int dogID) throws SQLException
    {
        System.out.println("before for loop");
        for(String path:paths){
            System.out.println("inside for loop");
            try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(INSERT_IMAGE_SQL);)
            {
                System.out.println("inside try");
                statement.setInt(1, dogID);
                statement.setString(2, path);
                statement.executeUpdate();
                statement.close();
//                disconnect();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        disconnect();
    }
    
    public List<AdoptionRequest> viewAllAdoptionRequests()
    {
        List<AdoptionRequest> adoptionRequests = new ArrayList<>();
        try(
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(VIEW_ALL_ADOPTION_REQUESTS);)
            {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
            
                while(resultSet.next())
                {
                    int requestID = resultSet.getInt("requestID");
                    String dogName = resultSet.getString("dogName");
                    String firstName = resultSet.getString("firstName");
                    String adoptionStatus = resultSet.getString("adoptionStatus");
                    float price = resultSet.getFloat("price");
                    String status = resultSet.getString("status");
             
                    adoptionRequests.add(new AdoptionRequest(requestID, dogName, firstName, adoptionStatus, price, status));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return adoptionRequests;
    }
}