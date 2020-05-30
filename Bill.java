/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql;

/**
 *
 * @author naam hai shehenshah
 */
public class Bill {
    
    String cstname;
    String cstmob,date;
    int billno,total,paid;

    public Bill()
    {
        
    }
    public Bill(int billno,String cstname, String cstmob,  int total, int paid,String date) {
        this.cstname = cstname;
        this.cstmob = cstmob;
        this.billno = billno;
        this.total = total;
        this.paid = paid;
        this.date=date;
    }

    public String getCstname() {
        return cstname;
    }

    public String getCstmob() {
        return cstmob;
    }

    public String getDate() {
        return date;
    }

    public int getBillno() {
        return billno;
    }

    public int getTotal() {
        return total;
    }

    public int getPaid() {
        return paid;
    }

    public void setCstname(String cstname) {
        this.cstname = cstname;
    }

    public void setCstmob(String cstmob) {
        this.cstmob = cstmob;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
    
   
}
