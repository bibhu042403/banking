import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.*;
import java.text.*;
import java.text.DecimalFormat;


public class validpass {
    
public static final int PASSWORD_LENGTH = 8;

public static void main(String[] args) {
String name,type;
int temp=0;
Scanner sc1=new Scanner(System.in);
Scanner str=new Scanner(System.in);
 
int aNumber = 0; 
aNumber = (int)((Math.random() * 9000)+1000); 
bank bn=new bank("user",0,0,"saving");
int ch;

        Scanner input = new Scanner(System.in);
	System.out.print("Set User Name:");
	String u=input.nextLine();
	System.out.print("Set password:");
       
        String s = input.nextLine();

        if (is_Valid_Password(s)) 
	{
		System.out.println("You have set your password successfuly! ");
		System.out.println("Ready for LOGIN! ");
	
        }
	else 
	{
           System.out.print(
                "1. A password must have at least eight characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits \n" +
                "Input a password (You are agreeing to the above Terms and Conditions.): ");
        }
	System.out.print("Enter User Name:");
	String U=input.nextLine();
		if(U.equals(u))
		{
			System.out.print("Enter the password: ");
			String p=input.nextLine();
				if(p.equals(s))
				{
				do{
System.out.println("MAIN MENU\n 1.Create_Account\n 2.Deposite\n 3.Withdraw\n 4.Account_Detail\n 5.Exit");
System.out.println("Enter your choise");
ch=sc1.nextInt();
switch(ch)
{
	case 1: System.out.print("Enter your name:");
		name=str.nextLine();
		System.out.print("Enter your account type:");
		type=sc1.next();
		bn.insert(name,aNumber,type);
		bn.display_details();
		System.out.println("\t\tDon't forget your Account Number!");
                break;  
	case 2: System.out.print("Enter account Number: ");
		temp=sc1.nextInt();
			if(temp==bn.acc_no)
			{
				
				bn.deposite();
			}
			else
			{
				System.out.println("Invalid Account Number\n Please Enter valid Account Number!\n");
			}
		break;
	case 3: System.out.print("Enter account number: ");
		temp=sc1.nextInt();
			if(temp==bn.acc_no)
			{
				bn.withdraw();
			}
			else
			{
				System.out.println("Invalid acoount Number\n Please Enter valid account number!");
			}
				
			break;
	case 4: bn.display_details();
		break;
	case 5:
		System.out.println("*****THANKS!*****");
		break;
}
}
while(ch!=5);
		}
		else
		{
			System.out.println("\nInvalid password! ");
			System.out.println("Please enter your valid password ");
		}

		}
				
		else
		{
			System.out.println("User name is invalid");
		}
	

    }

    public static boolean is_Valid_Password(String password) {

        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++)
	 {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }
 
}




class bank extends account{
Scanner sc=new Scanner(System.in);

bank(String n,int ac_no,int bal,String act_type){ // pass name and account type 
		name=n;
		acc_no=ac_no;
		acc_type=act_type;
		balance=bal;

    }
    bank(){
        super();
    }
  void insert(String n,int ac_no,String act_type){ // input user name, account number and type 
		name=n;
		acc_no=ac_no;
		acc_type=act_type;
		balance=0;
    }

    
    void display_details(){
System.out.println("\n\t\tYOUR ACCOUNT DETAIL");
	System.out.println("\t________________________________");
    
        System.out.println("\t\tDepositor Name  :" +name );
        System.out.println("\t\tAccount Number  :"+acc_no );
        System.out.println("\t\tAccount Balance :"+"Rs "+balance);
	System.out.println("\t\tAccount Type    :"+acc_type);
	System.out.println("\t________________________________");
    }
 


void withdraw(){
System.out.print("Enter Amount to withdraw Rs:");
int amount=sc.nextInt();
	if(amount<=balance)
	{
		balance=balance-amount;
		System.out.println("\nRs:"+amount+" has been debited and your current balance is Rs:"+balance);
	}
	else
	{
		System.out.println("  You don't have sufficient balance in your Account! ");
	}
}


void deposite(){
System.out.print("Enter amount to deposite Rs:");
int amount=sc.nextInt();
balance=balance+amount;
System.out.println("\nRs:"+amount+" has been credited and your current balance is Rs: "+balance);
}
}


class account{
String name,acc_type;
int acc_no,balance;
account(){
}

account(String n,int ac_no,int bal,String act_type){
name=n;
acc_type=act_type;
acc_no=ac_no;
balance=bal;

}
}







