/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author naam hai shehenshah
 */
public class billconsole {
    ArrayList <String> namelist;
    static String psmquery,query="";
    static Connection con;
   static Statement sm;
   static ResultSet rs;
   PreparedStatement psm,psm1;
   
    billconsole()
    {
 
        try{  
Class.forName("com.mysql.jdbc.Driver");  
con=Connectionn.getConnection();
sm=con.createStatement();  
 psmquery="select * from itemslist where name =?";
 psm1= con.prepareStatement(psmquery);
         
}catch(Exception e){ System.out.println(e+"constuctor");}
  
        try
               {
        query="create database if not exists BillDetails";
        sm.execute(query);
        sm.execute("use BillDetails");
        query="create table if not exists customerDetails( billno int(3) primary key auto_increment,name varchar(50),mobile varchar(10),total int(4),paid int(1),date varchar(11))";
        sm.execute(query);
        
               }catch(Exception e)
               {
                   System.out.print(e+" constbillconsole");
               }
    }


    
    String getproductname(String name) 
    {
        try
        {
      sm.execute("use Bill");
       psm1.setString(1, name);
      rs=  psm1.executeQuery();
      rs.next();
      return rs.getString("name");
       }
        catch(Exception e)
        {
            System.out.print(e+"getproduct");
        }
        return null;
    }
    
    int getproductprice(String name)
    {
        try
        {
            sm.execute("use Bill");
         psm1.setString(1, name);
      rs=  psm1.executeQuery();
       rs.next();
      return rs.getInt("price");
        }
        catch(Exception e)
        {
            
        }
      return 0;
    }
    
    int getproductid(String name)
    {
        try
        {
      sm.execute("use Bill");
       psm1.setString(1, name);
      rs=  psm1.executeQuery();
       rs.next();
      return rs.getInt("id");
        }
        catch(Exception e)
        {
            
        }
      return 0;

    }
    
    int getproductstock(String name)
    {
        try
        {
      sm.execute("use Bill");
       psm1.setString(1, name);
      rs=  psm1.executeQuery();
       rs.next();
      return rs.getInt("stock");
        }
        catch(Exception e)
        {
            
        }
      return 0;

    }
    int updateStock(String name,int qty,int stock)
    {
         try
        {
      sm.execute("use Bill");
     // int s=stock;
      stock=stock-qty;
      if(stock>=0)
          sm.execute("update itemslist set stock ="+stock+" where name='"+name+"'");
      else {
          return stock;
             }
      
        }
        catch(Exception e)
        {
            
        }
         return stock;
    }
    void createBillTable(String csmmob) throws SQLException
    {
        sm.execute("use billdetails");
        query="create table m"+ csmmob + "( name varchar(50),price int(3),qty int(2))";
        sm.execute(query);
       
    }
   
    void copyBillToTable(prodb p,String csmname,String csmmob,int total,int paid,String date)
        {
            //product pp;
            
            
            try
            {
            sm.execute("use BillDetails");
            query="insert into customerDetails (name,mobile,total,paid,date) value (?,?,?,?,?)";
             psm =  con.prepareStatement(query);
             
             psm.setString(1,csmname);
             psm.setString(2,csmmob);
             psm.setInt(3,total);
             psm.setInt(4,paid);
             psm.setString(5,date);
             psm.execute();
           
            query="insert into m"+csmmob+" value (?,?,?)";
            psm =  con.prepareStatement(query);
               
            for(int i=0;i<p.getSize();i++)
            {
               
                psm.setString(1,p.getItem(i).getName());
                psm.setInt(2,p.getItem(i).getPrice());
                psm.setInt(3,p.getItem(i).getQty());
                psm.execute();
            }
            }catch (Exception e){System.out.print(e);}
            
        }


    
 
    
    String autocomplte(String name)
    {
      
        query="select name from itemslist where name like '"+name+"%'";
        
        try
        {
        sm= con.createStatement();
        sm.execute("use Bill");
        rs= sm.executeQuery(query);
        rs.next();
        return rs.getString("name");
        }
        catch(Exception e)
        {
            return null;
        }  
    }
   int getlastbillno()
   {
       query="select billno from customerDetails order by billno desc";
        try
        {
        sm.execute("use Billdetails");
        sm= con.createStatement();
        rs= sm.executeQuery(query);
        rs.next();
        return rs.getInt("billno");
        }
        catch(Exception e)
        {
            return -1;
        }  
   }
    
}
