/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author naam hai shehenshah
 */
public class BillDetail {
    Statement sm;
    ResultSet rs;
   Connection con;
   String query;
   ArrayList <Bill> blist;
   ArrayList <product> plist;
   
   BillDetail()
   {
       blist = new ArrayList <Bill>();
     try{ 
               Class.forName("com.mysql.jdbc.Driver");  
                con=Connectionn.getConnection();
                sm=con.createStatement();
               
                
       }catch(Exception e)
       {
           System.out.print(e);
       }
       getbill();
   }
   
   
   void getbill()
   {
       
       
       int b,t,p;
       String n,m,d;
       Bill B;
        try {
            query="use Billdetails";
           sm.execute(query);
           query="select * from customerDetails";
            rs= sm.executeQuery(query);
            while(rs.next())
            {
               b= rs.getInt("billno");
               n= rs.getString("name");
               m= rs.getString("mobile");
               t= rs.getInt("total");
               p= rs.getInt("paid");
               d= rs.getString("date");
               B= new Bill(b,n,m,t,p,d);
               blist.add(B);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }

    public ArrayList<Bill> getBilllist() {
        return blist;
    }
   
   int searchBill(int billno)
   {
       for(int i=0;i<blist.size();i++)
      {
          if(blist.get(i).getBillno()==billno)
          return i;
      }
      return -1;
   }
   
   void removeBill(Bill b)
   {
       query="delete from customerdetails where billno = "+b.getBillno();
       
      try
      {
      sm.execute("use Billdetails");
      sm.execute(query);
      query="drop table m"+b.getCstmob();
      sm.execute(query);
      }
      catch(Exception e)
      {
         System.out.print(e); 
      }
   }
   
   
   void updatecstname(int billno,String newname)
   {
         query="update customerdetails set name = '"+newname+"' where billno= "+billno;
        try
      {
      sm.execute("use Billdetails");
      sm.execute(query);
      billno=searchBill(billno);
      Bill b=blist.get(billno);
      b.setCstname(newname);
      blist.set(billno, b);
      }
      catch(Exception e)
      {
        System.out.print(e);             
      }
   }
   
   void updatepaid(int billno)
   {
      int index=searchBill(billno);
       int paid=blist.get(index).getPaid();
       if(paid==1) paid=0;
       else paid=1;
       try{
           query="update customerdetails set paid ="+paid+" where billno ="+billno;
           sm.execute("use Billdetails");
           sm.execute(query);
           Bill b;
           b=blist.get(index);
           b.setPaid(paid);
           blist.set(index, b);
        }
      catch(SQLException ex)
      {
       Logger.getLogger(BillDetail.class.getName()).log(Level.SEVERE, null, ex);           
      }
   }
   
   void updatemobile(int billno,String newmob) throws SQLException
   {
           
      
      sm.execute("use Billdetails");
      
      int index=searchBill(billno);
      Bill b=blist.get(index);
      query="rename table m"+b.getCstmob()+" to m"+newmob;
      sm.execute(query);
      query="update customerdetails set mobile = '"+newmob+"' where billno= "+billno;
      sm.execute(query);
      b.setCstmob(newmob);
      blist.set(index, b);
     
      
   }
   
   
   ArrayList<product> getBillData(String mob)
   {
       plist= new ArrayList<product>();
       product pp;
       try
       {
           query="select * from m"+mob;
           rs=sm.executeQuery(query);
           while(rs.next())
           {
               String name=rs.getString("name");
               int p=rs.getInt("price");
               int q=rs.getInt("qty");
               pp=new product(name,p,q);
               plist.add(pp);
           }
        }
      catch(SQLException ex)
      {
       Logger.getLogger(BillDetail.class.getName()).log(Level.SEVERE, null, ex);            
      }
       
       return plist;
   }
   
   void removeAllBillDatabase()
   {
       try
       {
           query="drop database billdetails";
           sm.execute(query);
     }
      catch(Exception e)
      {
        System.out.print(e);             
      }
         
   }
   
  
}
