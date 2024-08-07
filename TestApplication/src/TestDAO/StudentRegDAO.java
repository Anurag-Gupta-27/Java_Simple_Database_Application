/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDAO;

import TestDB.DBConnection;
import TestDTO.StudentRegDTO;
import java.sql.*;

/**
 *
 * @author Anurag
 */
public class StudentRegDAO {
    //DAO for accessing the data from the database
    
    public int saveData(StudentRegDTO t1)
    {
        int x=0;    
        try{
            Connection con1=DBConnection.getConn();
            PreparedStatement ps= con1.prepareStatement
            ("insert into student(sname,sadd,mob,branch,unm,pass) values(?,?,?,?,?,?)");
             ps.setString(1, t1.getSname());
             ps.setString(2,t1.getSadd());
             ps.setInt(3, t1.getMob());
             ps.setString(4, t1.getBranch());
             ps.setString(5, t1.getUnm());
             ps.setString(6, t1.getPass());
             x=ps.executeUpdate();
        }
        catch(Exception tt)
        {
            System.out.println(tt);
        }
        return x;
    }
    
    public int updateData(StudentRegDTO t1, String uid){
        int x = 0;
        try{
            Connection con1 = DBConnection.getConn();
            PreparedStatement ps = con1.prepareStatement("update student set sname=?, sadd=?, mob=?, branch=?, unm=?, pass=? where sid=?");
            ps.setString(1, t1.getSname());
            ps.setString(2, t1.getSadd());
            ps.setInt(3, t1.getMob());
            ps.setString(4, t1.getBranch());
            ps.setString(5, t1.getUnm());
            ps.setString(6, t1.getPass());
            ps.setString(7, uid);
            x=ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return x;
    }
    
    public int deleteData(String uid){
        int x = 0;
        try{
            Connection con1 = DBConnection.getConn();
            PreparedStatement ps = con1.prepareStatement("update student set status=1 where sid=?");
            ps.setString(1, uid);
            x = ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return x;
    }
    
    public StudentRegDTO getData(int id){
        
        StudentRegDTO d1 = new StudentRegDTO();
        
        try{
            Connection con1 = DBConnection.getConn();
            Statement stm = con1.createStatement();
//            System.out.println(stm);
            
            ResultSet rs = stm.executeQuery("select * from student where sid="+id);
            if(rs.next()){
                //here we used if because we only want to show the user one by one but if we want to show all of them we can use while
                d1.setId(rs.getInt(1));
                d1.setSname(rs.getString(2));
                d1.setSadd(rs.getString(3));
                d1.setMob(rs.getInt(4));
                d1.setBranch(rs.getString(5));
                d1.setUnm(rs.getString(6));
                d1.setPass(rs.getString(7));
            }
        }
        catch (Exception e){
            System.out.println("Error : "+e);
        }
        return d1;
    }
    
    public ResultSet getAllData(){
        ResultSet rs = null;
        try{
            Connection con1 = DBConnection.getConn();
            Statement stm = con1.createStatement();
            rs = stm.executeQuery("select * from student where status=0");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
}
