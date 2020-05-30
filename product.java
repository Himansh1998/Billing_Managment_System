/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author naam hai shehenshah
 */
public class product {
    
   
    int id ,price,qty,stock;
    String name;
    public product() 
    {
    }
    
      public product(int id, String name, int price,int qty,int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
       this.qty=qty;
      this.stock=stock;
       
    }
   public product( String name, int price,int qty) {
        
        this.name = name;
        this.price = price;
        this.qty=qty;
    }
      public product(int id, String name, int price,int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
      
      this.stock=stock;
       
    }

    public int getId() {
        return id;
    }
   public int getStock() {
        return stock;
    }
    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


      public int getQty() {
        return this.qty;
    }
    
 public String toString()
    {
        return (id+"\t" + name+"\t" + price+"\t" +qty );
    }
    
   
    }

