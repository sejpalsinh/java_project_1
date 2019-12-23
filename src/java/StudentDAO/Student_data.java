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
import java.sql.Statement;

/**
 *
 * @author sejpalsinh
 */
public class Student_data {

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
            Connection con = Student_data.getConnection();
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

    public static int update(Students s, String t_enum) {
        int status = 0;
        try {
            Connection con = Student_data.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE `student_data` SET `name`= '?' ,`email`= '?',`enumber`='?',`pass`='?' WHERE `enumber`='?' ");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getEnumber());
            ps.setString(4, s.getPass());
            ps.setString(5, t_enum);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(String t_enum) {
        int status = 0;
        try {
            Connection con = Student_data.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM `student_data` WHERE `enumber`='?' ");
            ps.setString(1, t_enum);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static boolean check_user(String uname, String pass) {
        int status = 0;
        try {
            Statement stmt = null;
            Connection con = Student_data.getConnection();
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
