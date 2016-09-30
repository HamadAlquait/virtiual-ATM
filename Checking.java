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
public class Checking extends Accounts
{
     
    public Checking(double begin_balance)
    {
        Accounts mo = new Accounts();
        mo.balance = begin_balance;
    }
    
    public void getInterest()
    {
        int datediff = seconddate - firstdate;
        double ratetime;
        
        rate = .05/365;
        
        ratetime = Math.pow(1 + rate, datediff);        
        
        balance *= ratetime;
        
        firstdate = seconddate;
    }
}