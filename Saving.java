/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ASG2;

/**
 *
 * @author omsf7f
 */




//NOTES FROM CLASS
public class Saving extends Accounts
{
    
//    public Saving (double begin_balance)
//    {
//        super(begin_balance);
//    }
    
    public Saving (double begin_balance)
    {
        Accounts mo = new Accounts();
        mo.balance = begin_balance;
    }//End Initial Constructor
    
    
    
    public void getSavingInterest()
    {
        int datediff = seconddate = firstdate;
        rate = .05/365;
        double ratetime = Math.pow(1 + rate , datediff);
        balance = balance * ratetime;
        firstdate = seconddate;
       
    }
}
