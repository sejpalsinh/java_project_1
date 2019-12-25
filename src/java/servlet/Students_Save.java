/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import POJOs.Students;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Students_Save extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name,email,e_num,pass;
        name = req.getParameter("name");
        email = req.getParameter("email");
        e_num = req.getParameter("enum");
        pass = req.getParameter("psw");
        Students se = new Students(name, email, pass, e_num);
        StudentDAO.Student_data_connection.save(se);
        resp.sendRedirect("index.html");
    }

  
}
