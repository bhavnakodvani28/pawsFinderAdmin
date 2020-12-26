/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pawsFinder.admin.DAO.DogDAO;
import pawsFinder.admin.model.Dog;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import javax.servlet.http.Part;
import pawsFinder.admin.model.AdoptionRequest;

/**
 *
 * @author user
 */
@WebServlet(name = "DogServlet", urlPatterns = {"/DogServlet"})
public class DogServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "E:/DAIICT";
    private DogDAO dogDAO;
    
    
    public DogServlet(){
        this.dogDAO = new DogDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        System.out.println(action);
        switch(action)
        {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                try {
                    insertDog(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteDog(request, response);
                } catch (SQLException e) {
                     e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    updateDog(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "status":
                try {
                    showUpdateStatusForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "statusUpdate":
                try {
                    updateStatus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "adoptionRequest":
                    try {
                    listAdoptionRequests(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listDog(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    
    private void listDog(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        List<Dog> listDog = dogDAO.viewAllDogs();
        request.setAttribute("listDog", listDog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dogList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listAdoptionRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        List<AdoptionRequest> listAdoptionRequests = dogDAO.viewAllAdoptionRequests();
        request.setAttribute("listAdoptionRequests", listAdoptionRequests);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adoptionRequests.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        int dogID = Integer.parseInt(request.getParameter("dogID"));
        Dog existingDog = dogDAO.selectDog(dogID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateForm.jsp");
        request.setAttribute("dog", existingDog);
        dispatcher.forward(request, response);
    }
    
    private void updateDog(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        int dogID = Integer.parseInt(request.getParameter("dogID"));
        String dogName = request.getParameter("dogName");
        int dogAge = Integer.parseInt(request.getParameter("dogAge"));
        String dogSize = request.getParameter("dogSize");
        String gender = request.getParameter("gender");
        String breed = request.getParameter("breed");
        String color = request.getParameter("color");
        String city = request.getParameter("city");
        String description = request.getParameter("description");
        String adoptionStatus = request.getParameter("adoptionStatus");
        String friendly = request.getParameter("friendly");
        float  price = Float.parseFloat(request.getParameter("price"));
        
        
        Dog updatedDog = new Dog(dogID, dogName, dogAge, dogSize, gender, breed, color, city, description,adoptionStatus, friendly, price);
        dogDAO.updateDog(updatedDog);
        listDog(request,response);
    }
    
    private void showUpdateStatusForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        int dogID = Integer.parseInt(request.getParameter("dogID"));
        Dog existingDog = dogDAO.selectDog(dogID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateAdoptionStatus.jsp");
        request.setAttribute("dog", existingDog);
        dispatcher.forward(request, response);
    }
    
    private void updateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        int dogID = Integer.parseInt(request.getParameter("dogID"));
        String dogName = request.getParameter("dogName");
        String breed = request.getParameter("breed");
        String adoptionStatus = request.getParameter("adoptionStatus");
        float  price = Float.parseFloat(request.getParameter("price"));
        
        Dog updatedStatus = new Dog(dogID, dogName, breed,adoptionStatus, price);
        dogDAO.updateStatus(updatedStatus);
        listDog(request,response);
    }
    
    private void deleteDog(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException
    {
        int dogID = Integer.parseInt(request.getParameter("dogID"));
        dogDAO.deleteDog(dogID);
        listDog(request,response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dogForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertDog(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException
    {
        String dogName = request.getParameter("dogName");
        int dogAge = Integer.parseInt(request.getParameter("dogAge"));
        String dogSize = request.getParameter("dogSize");
        String gender = request.getParameter("gender");
        String breed = request.getParameter("breed");
        String color = request.getParameter("color");
        String city = request.getParameter("city");
        String description = request.getParameter("description");
        String friendly = request.getParameter("friendly");
        float  price = Float.parseFloat(request.getParameter("price"));
        
        Dog newDog = new Dog(dogName, dogAge, dogSize, gender, breed, color, city, description, friendly, price);
        dogDAO.insertDog(newDog);
         
        listDog(request,response);
    }
    
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
