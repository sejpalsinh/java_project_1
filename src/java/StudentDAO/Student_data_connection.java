/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentDAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import POJOs.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sejpalsinh
 */
public class Student_data_connection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student_java?user=root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Students s) {
        int status = 0;
        try {
            Connection con = Student_data_connection.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO `student_data`( `name`, `email`, `enumber`, `pass`) VALUES (?,?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getEnumber());
            ps.setString(4, s.getPass());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(String name,String email,String enroll, int sid) {
        int status = 0;
        try {
            Connection con = Student_data_connection.getConnection();
            Statement stmt = null;
            stmt = (Statement) con.createStatement();
            String query1 = "UPDATE `student_data` SET `name`= '"+name+"' ,`email`= '"+email+"',`enumber`='"+enroll+"' WHERE `id`="+sid+" ";
            int i = stmt.executeUpdate(query1);
            System.out.println(query1);
            con.close();
            return i;
        } catch (SQLException ex) {
            return 0;
        }

       
    }

    public static int delete(int sid) {
        int status = 0;
        try {
            Connection con = Student_data_connection.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM `student_data` WHERE `id`= ? ");
            ps.setInt(1, sid);
            System.out.print(ps);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex);
        }

        return status;
    }

    public static boolean check_user(String uname, String pass) {
        int status = 0;
        try {
            Statement stmt = null;
            Connection con = Student_data_connection.getConnection();
            stmt = con.createStatement();

            String sql = "SELECT `id` FROM `student_data` WHERE `email`='"+uname+"'  AND `pass` ='"+pass+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
