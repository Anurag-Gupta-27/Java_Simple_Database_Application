/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TestDB;

/**
 *
 * @author Anurag
 */
public interface DBConfig {
    //connection information
    String driver = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/night_batch";
    String unm = "root";
    String pass = "";
}
