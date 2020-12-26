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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "AdoptionRequestApprove", urlPatterns = {"/AdoptionRequestApprove"})
public class AdoptionRequestApprove extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public AdoptionRequestApprove() 
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
            stmt.executeUpdate("UPDATE adoptionrequest,dogtbl SET adoptionrequest.STATUS='approved', dogtbl.adoptionStatus='YES' WHERE adoptionrequest.dogID=dogtbl.dogID AND requestID="+requestID);// Parse id into integer if needed.
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully approved');");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
