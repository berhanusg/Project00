package com.revature.berhanu.prj0;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CLITransfereringFunds {
       public void transferFunds(){

        /// Create the following objects: objAccount , objUser, objTransaction
        Account objSourceAccount = new Account();
        Account objDestinationAccount= new Account();
        AccountUser objaccountUser = new AccountUser();
        Transaction objTransaction = new Transaction();

        String   tsourceaccountid,  tdestinationaccountid, amount, date, time, transactiontype, remark;
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Source Account number you want to transfer from");
        String sourceAccountNumber = sc.nextLine();
        objSourceAccount= (Account) objSourceAccount.getSingleAccount(sourceAccountNumber);
        tsourceaccountid =  objSourceAccount.accountid;
        

        System.out.println("Enter the Destination Account number you want to transfer to ");
        String destinationAccountNumber = sc.nextLine();
        objDestinationAccount= (Account) objDestinationAccount.getSingleAccount(destinationAccountNumber);
        tdestinationaccountid = objDestinationAccount.accountid;


        System.out.println("Enter the Amount you want to transfer");
        amount = sc.nextLine();

        System.out.println("Any remarks ?");
        remark = sc.nextLine();
        Date objDate = new Date();
        SimpleDateFormat objFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        objFormatter.format(objDate);
        date = objDate.toString();
        time = objDate.toString();
        transactiontype = "Credit";

        Double objSourceBalance = Double.parseDouble(objSourceAccount.accountbalance);
        Double objDestinaitonBalance = Double.parseDouble(objDestinationAccount.accountbalance);
        Double objTransferAmount = Double.parseDouble(amount);
        if (objSourceBalance >= objTransferAmount )
        {
            Double SBalance = objSourceBalance - objTransferAmount;
            Double DBalance = objDestinaitonBalance + objTransferAmount;
            objSourceAccount.updateAccount(objSourceAccount.accountid, objSourceAccount.aaccounttypeid, SBalance.toString(), objSourceAccount.accountownershiptype, objSourceAccount.accountnumber, objSourceAccount.accountstatus, "Funds have been Deducted");
            objDestinationAccount.updateAccount(objDestinationAccount.accountid, objDestinationAccount.aaccounttypeid, DBalance.toString(), objDestinationAccount.accountownershiptype, objDestinationAccount.accountnumber, objDestinationAccount.accountstatus, "Funds have been Transfered");
            objTransaction.createTransaction( tsourceaccountid, tdestinationaccountid, amount, date, time, transactiontype, remark);

        }
        else if(objSourceBalance < objTransferAmount )
        {
            System.out.println("Insufficent Funds");
        }

      
      

        


         


       }
}
