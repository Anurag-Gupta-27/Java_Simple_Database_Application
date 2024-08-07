/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDB;

/**
 *
 * @author Anurag
 */

import java.sql.*;

public class DBConnection implements DBConfig {
    //here we are making a connection for the whole package in a single file so that we don't have to do it every time
    
    public static Connection getConn(){
        Connection con = null;
        try{
            //opening the driver
            Class.forName(driver);
            System.out.println("Driver Open");
            
            //Connecting to the database
            con = DriverManager.getConnection(URL, unm, pass);
            System.out.println("Connection Eastablished Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
