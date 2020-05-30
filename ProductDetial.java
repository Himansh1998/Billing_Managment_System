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
public class ProductDetial {
     static Connection con;
    static Statement sm;
   static ResultSet rs;
   PreparedStatement psm,psm1;
   String query;
   ArrayList <product> productlist;
   
  /* static
           {
       try{ 
               Class.forName("com.mysql.jdbc.Driver");  
                con=Connectionn.getConnection();
                sm=con.createStatement();
               
                
       }catch(Exception e)
       {
           System.out.print(e);
       }
           }
*/
    public ProductDetial() {
        
        
         try{ 
               Class.forName("com.mysql.jdbc.Driver");  
                con=Connectionn.getConnection();
                sm=con.createStatement();
               
                
       }catch(Exception e)
       {
           System.out.print(e);
       }
        try
        {
          sm.execute("use bill");
          sm.execute("create table if not exists itemslist (id int(3) primary key auto_increment,name varchar(30),price int(3),stock int(3))");    
        }catch(Exception e)
        {
            System.out.print(e);
        }
        
        getProductDetial();
    }
 
   
   
   void getProductDetial()
   {
       productlist =new ArrayList <product> ();
       try
         {
      sm.execute("use Bill");
      query="select * from itemslist";
      rs = sm.executeQuery(query);
      product p;
      while(rs.next())
      {
          int id=rs.getInt("id");
          String s=rs.getString("name");
          int pri=rs.getInt("price");
          int stock=rs.getInt("stock");
          p=new product(id,s,pri,stock);
          productlist.add(p);
      }
       }
        catch(Exception e)
        {
            System.out.print(e);
        }
   }
   
   
   ArrayList <product> getProList()
   {
       return productlist;
   }
   
  int searchProduct(int id)
  {
      for(int i=0;i<productlist.size();i++)
      {
          if(productlist.get(i).getId()==id)
          return i;
      }
      return -1;
  }
  
  void removeProduct(product p)
  {
      query="delete from itemslist where name = '"+p.getName()+"'";
      try
      {
      sm.execute("use Bill");
      sm.execute(query);
      }
      catch(Exception e)
      {
         System.out.print(e); 
      }
  }
  
  void updateName(String oldname,String newname)
  {
      query="update itemslist set name = '"+newname+"' where name= '"+oldname+"'";
        try
      {
          sm.execute("use Bill");
      sm.execute(query);
      }
      catch(Exception e)
      {
        System.out.print(e);             
      }
  }
  
    void updateDetail(String var,String oldname,int neww)
  {
      query="update itemslist set "+var+" = '"+neww+"' where name= '"+oldname+"'";
        try
      {
      sm.execute("use Bill");
      sm.execute(query);
      }
      catch(Exception e)
      {
        System.out.print(e);
                  
      }
  }
    
    
    void AddPRODUCT(product p)
    {
        query="insert into itemslist (name,price,stock) value ('"+p.getName()+"' ,"+p.getPrice()+" , "+p.getStock()+")";
        
          try
      {
      sm.execute("use Bill");
      sm.execute(query);
      }
      catch(Exception e)
      {
        System.out.print(e);
                  
      }
    }
    
    void removeALLDATA()
    {
        for(int i=0;i<productlist.size();i++)
        productlist.remove(i);
        
        query="drop table itemslist";
             try
      {
      sm.execute("use Bill");
      sm.execute(query);
      }
      catch(Exception e)
      {
        System.out.print(e);
                  
      }
    }
}
