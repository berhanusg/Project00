package com.revature.berhanu.prj0;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;


public class App 
{
    public static void main( String[] args )
    {
       /* Account objAccount = new Account();
        System.out.println(objAccount.getLastDataEntry());*/
        CLIFrontView objDrawFrontPage = new CLIFrontView();
        objDrawFrontPage.welcome("Employee");
        
     
    }
}
