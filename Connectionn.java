/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author naam hai shehenshah
 */
public class Connectionn {
     private static Connection con;
    public static Connection  getConnection()
    {
        try {
            if(con==null)
                    con= DriverManager.getConnection("jdbc:mysql://localhost/?","root","himansh");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static void closeConnection()
    {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
