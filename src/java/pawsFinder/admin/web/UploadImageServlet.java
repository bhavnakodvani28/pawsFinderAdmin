/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import pawsFinder.admin.DAO.DogDAO;

/**
 *
 * @author user
 */
@WebServlet(name = "UploadImageServlet", urlPatterns = {"/UploadImageServlet"})
public class UploadImageServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "E:\\DAIICT\\Semester3\\PawsFinder-Project\\web\\assets\\images\\dogs";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In doPost method");
        if(ServletFileUpload.isMultipartContent(request))
        {
            ArrayList<String> paths = new ArrayList<String>();
            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
                for(FileItem item: multiparts)
                {
                    if(!item.isFormField())
                    {
                        String name = new File(item.getName()).getName(); 
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        String path = UPLOAD_DIRECTORY+File.separator+name;
                        paths.add(path);
                    }   
                }
                
                DogDAO obj= new DogDAO();
                
                System.out.println("before id");
                int id=Integer.parseInt(request.getParameter("dogID"));
                
                System.out.println("UPLOAD IMAGE SERVLET DOG:" + id);
                
                obj.insertImage(paths, id);
                
                request.getRequestDispatcher("dogList.jsp").forward(request, response);
            }
            catch(Exception e)
            {
                request.setAttribute("message", "File upload failed due to "+e);
            }
        }
        else
        {
            request.setAttribute("message", "sorry");
        }
        
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
