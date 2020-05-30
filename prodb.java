/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author naam hai shehenshah
 */
public class prodb {
    
    
    ArrayList <product> plist;
    prodb()
    {
        super();
       plist =new ArrayList<product>();
    }
    
      
    
       void setproduct (int index,product pp)
   {
       plist.set( index, pp );
   }
       
       
       product getproduct(int id)
   {
       for(int i=0;i<plist.size();i++)
       {
           if(id==plist.get(i).getId())
              return plist.get(i);
       }
       return null;
   }
       
       void addproduct(product pp)
       {
           plist.add(pp);
       }
       
        product getItem(int index)
    {
        return this.plist.get(index);
    }
        
        
    int getSize()
    {
        return plist.size();
    }
    
    int searchitem(int id)
    {
        for(int i=0;i<plist.size();i++)
        if(plist.get(i).getId()==id)
            return i;
        
        return -1;
    }
     
    void removeAll()
    {
        plist.removeAll(plist);
    }
    
    
    void remove(int itemid){
        for(int i=0;i<plist.size();i++)
        if(plist.get(i).getId()==itemid)
            plist.remove(i);
    }
    
    
    
    
}
