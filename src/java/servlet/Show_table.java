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
public class Show_table extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("<title>Bootstrap Example</title>");
        pw.println("<meta charset='utf-8'>");
        pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
        pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>");
        pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<div class='container'>");
        pw.println("<h2>Striped Rows</h2>");
        pw.println("<p>The .table-striped class adds zebra-stripes to a table:</p>");            
        pw.println("<table class='table table-striped'>");
        pw.println("<thead>");
        pw.println("<tr>");
        pw.println("<th>Firstname</th>");
        pw.println("<th>Lastname</th>");
        pw.println("<th>Email</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
        for(int i=0; i<10; i++)
        {
            pw.println("<tr>");
            pw.println("<td>John</td>");
            pw.println("<td>Doe</td>");
            pw.println("<td>john@example.com</td>");
            pw.println("</tr>");            
        }
        pw.println("</tbody>");
        pw.println("</table>");
        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");
    }
    
}
