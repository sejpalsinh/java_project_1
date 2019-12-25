/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import StudentDAO.Student_data_connection;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sejpalsinh
 */
public class Student_Data_Show extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("    <meta charset='utf-8'>");
        pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.println("    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
        pw.println("    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>");
        pw.println("    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
        pw.println("    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>");
        pw.println("    <script>");
        pw.println("        $(document).ready(function()");
        pw.println("        {");
        pw.println("            var id_holder;");
        pw.println("            $('.btnupdate').click(function() {");
        pw.println("                $id_holder = $(this);");
        pw.println("                $('#name_update').val('');");
        pw.println("                $('#enroll_update').val('');");
        pw.println("                $('#email_update').val('');");
        pw.println("                $('#sid_update').val('');");
        pw.println("                var $name_data = $(this).closest('tr').find('#name').text();");
        pw.println("                var $enroll_data = $(this).closest('tr').find('#enroll').text();");
        pw.println("                var $email_data = $(this).closest('tr').find('#email').text();");
        pw.println("                var $sid_data = $(this).closest('tr').find('#sid').val();");
        pw.println("                //alert($name_data+' '+$enroll_data+' '+$email_data+' '+$sid_data);");
        pw.println("                $('#name_update').val($name_data);");
        pw.println("                $('#enroll_update').val($enroll_data);");
        pw.println("                $('#email_update').val($email_data);");
        pw.println("                $('#sid_update').val($sid_data);");
        pw.println("            });");
        pw.println("");
        pw.println("            $('#btn_do_update').click(function() ");
        pw.println("            {");
        pw.println("                var $name_data = $('#name_update').val();");
        pw.println("                var $enroll_data =  $('#enroll_update').val();");
        pw.println("                var $email_data =  $('#email_update').val();");
        pw.println("                var $sid_data = $('#sid_update').val();");
        pw.println("                //alert($name_data+' '+$enroll_data+' '+$email_data+' '+$sid_data);");
        pw.println("                $.ajax({");
        pw.println("                    url:'Student_update',");
        pw.println("                    data:{sid:$sid_data,name:$name_data,enroll:$enroll_data,email:$email_data},");
        pw.println("                    type:'POST',");
        pw.println("                    cache:false,");
        pw.println("                    success:function(data){");
        pw.println("                        alert(data);");
        pw.println("                    },");
        pw.println("                    error:function()");
        pw.println("                    {");
        pw.println("                        alert('error'); return; ");
        pw.println("                    }");
        pw.println("                });");
        pw.println("                $id_holder.closest('tr').find('#name').text($name_data);");
        pw.println("                $id_holder.closest('tr').find('#enroll').text($enroll_data);");
        pw.println("                $id_holder.closest('tr').find('#email').text($email_data);");               
        pw.println("            });");
        pw.println("");
        pw.println("            $('.btdelete').click(function() {");
        pw.println("                var $sid_data = $(this).closest('tr').find('#sid').val();");
        pw.println("             //   alert($sid_data);");
        pw.println("                $.ajax({");
        pw.println("                    url:'Student_Delete',");
        pw.println("                    data:{sid:$sid_data},");
        pw.println("                    type:'POST',");
        pw.println("                    cache:false,");
        pw.println("                    success:function(data){");
        pw.println("                        alert(data);");
        pw.println("                    },");
        pw.println("                    error:function()");
        pw.println("                    {");
        pw.println("                        alert('error');");
        pw.println("                        return;");
        pw.println("                    }");
        pw.println("                });");
        pw.println("                $(this).parent().parent().remove();");
        pw.println("            });");
        pw.println("        });");
        pw.println("    </script>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("");
        pw.println("");
        pw.println("<div class='container'>");
        pw.println("  <form class='form-inline' action='/action_page.php'>");
        pw.println("  </br></br></br>");
        pw.println("  <center>");
        pw.println("    <div class='form-group'>");
        pw.println("      <input type='text' class='form-control' id='name_update' placeholder='Enter Name'  name='email'>");
        pw.println("    </div>");
        pw.println("    <div class='form-group'>");
        pw.println("      <input type='text' class='form-control' id='enroll_update' placeholder='Enter Enrollment number' name='pwd'>");
        pw.println("    </div>");
        pw.println("    <div class='form-group'>");
        pw.println("      <input type='email' class='form-control' id='email_update' placeholder='Enter Email' name='pwd'>");
        pw.println("    </div>");
        pw.println("    <div class='form-group'>");
        pw.println("      <input type='hidden' class='form-control' id='sid_update'  value='3487'  >");
        pw.println("    </div>");
        pw.println("    <button type='button' class='btn btn-primary' id='btn_do_update'>Update</button>");
        pw.println("  </form>");
        pw.println("  </center>");
        pw.println("</div>");
        pw.println("");
        pw.println("");
        pw.println("</br></br></br>");
        pw.println("<div class='container'>         ");
        pw.println("  <table class='table table-condensed'>");
        pw.println("    <thead>");
        pw.println("      <tr>");
        pw.println("        <th>Name</th>");
        pw.println("        <th>Enrollment</th>");
        pw.println("        <th>Email</th>");
        pw.println("        <th>Edit</th>");
        pw.println("        <th>Delete</th>");
        pw.println("      </tr>");
        pw.println("    </thead>");
        pw.println("    <tbody>");
        Connection con = Student_data_connection.getConnection();
            Statement stm = null;
            ResultSet rst = null;
        try{
            stm = con.createStatement();
            String sql = "SELECT * FROM `student_data` WHERE 1"; 
            rst = stm.executeQuery(sql);  
        }
        catch(Exception e)
        {
            
        }
        try { 
            while (rst.next())
            {
                pw.println("     <tr>");
                pw.println("        <td id='name' >"+rst.getString("name")+"</td>");
                pw.println("        <td id='enroll' >"+rst.getString("enumber")+"</td>");
                pw.println("        <td id='email' >"+rst.getString("email")+"</td>");
                pw.println("        <td><button type='button' class='btn btn-success btnupdate' >Edit</button></td>");
                pw.println("        <td><button type='button' class='btn btn-danger btdelete' >Delete</button></td>");
                pw.println("        <td><input type='hidden' id='sid' name='sid' value='"+rst.getString("id")+"'></td>");
                pw.println("      </tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_Data_Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        pw.println("    </tbody>");
        pw.println("  </table>");
        pw.println("</div>");
        pw.println("");
        pw.println("</body>");
        pw.println("</html>");
    }
    
}
