/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sejpalsinh
 */
public class Student_Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        
        int i = StudentDAO.Student_data_connection.delete(Integer.parseInt(req.getParameter("sid")));
        PrintWriter pw = resp.getWriter();
        if(i==1)
            pw.println("Record deleted Successfully");
        else
            pw.println("Error While deleting Record");
    }

}
