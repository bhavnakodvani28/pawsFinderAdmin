/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "AdoptionRequestReject", urlPatterns = {"/AdoptionRequestReject"})
public class AdoptionRequestReject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdoptionRequestReject() 
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        
        try
        {  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawsfinder","root","");
            Statement stmt=con.createStatement();  
            String requestID = request.getParameter("requestID");
            stmt.executeUpdate("UPDATE adoptionrequest,dogtbl SET adoptionrequest.STATUS='approved', dogtbl.adoptionStatus='NO' WHERE adoptionrequest.dogID=dogtbl.dogID AND requestID="+requestID);// Parse id into integer if needed.
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You have rejected this adoption request');");
            out.println("location='adoptionRequests.jsp';");
            out.println("</script>"); 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
