import java.util.*;
public class AtmInterface
{
	static Scanner input = new Scanner(System.in);
	static String userId;
    static int acc_no;
    static int pin;
    static float bal = 100000f;
    static int trans = 0;
    static String tranHis = "";
    
	static void register() {
		System.out.println("\nEnter your Username  :");
        userId = input.next();
        System.out.println("ENTER YOUR ACCOUNT NUMBER  :");
        acc_no = input.nextInt();
        System.out.println("ENTER YOUR ATM PIN  :");
        pin = input.nextInt();
        System.out.println("\nRegistration completed. Successfully!!");
        System.out.println("Now you can login to your account.");
	}
	static void withdraw()
	{
		System.out.println("Enter the amount to withdraw:");
		float amt = input.nextFloat();
		if(amt > bal) {
			System.out.println("Your current balance is low!!!");
		}
		else
		{
			System.out.println("Withdrawal is SUCCESS!!!");
			bal -= amt;
			System.out.println("Your current balance is "+bal);
			trans += 1;
			String s = amt +" is withdrawn"+"\n";
			tranHis += s;
		}
	}
	static void tranHistory()
	{
		if(trans == 0)
			System.out.println("No Transactions");
		else
		{
			System.out.println("You performed "+trans+" transactions");
			System.out.println(tranHis);
		}
	}
	static void deposit()
	{
		System.out.println("Enter the amount to deposit");
		float dep = input.nextFloat();
		bal += dep;
		System.out.println("Your current balance is "+bal+" after depositing");
		trans += 1;
		String s = dep +" is deposited"+"\n";
		tranHis += s;
	}
	static void checkBal()
	{
		System.out.println("Your current balance is "+bal);
	}
	static boolean login()
	{
		boolean flag = false;
        int i;
		for(i =0;i<3;i++)
		{
			System.out.println("Enter your pin number:");
			int pin1 = input.nextInt();
			if(pin1 == pin)
			{
				System.out.println("Logged in successfully");
				flag = true;
				break;
			}
		}
		if(i==3)
			System.out.println("You have exceeded your attempts try after 24 hours!!!");
		return flag;
	}
	static void transfer()
	{
		 System.out.println("\nEnter the Account number you want to transfer to : ");
	     String accno = input.next();
	     System.out.println("Enter the amount you want to transfer : ");
	     float tran = input.nextInt();
	     if(tran<=bal)
	     {
	         System.out.println("\nMoney Transfered Successfully");
	         bal = bal-tran;
	         System.out.println("Your current balance is : "+bal);
	         trans+=1;
	         String s = tran+" transfered from account\n";
	         tranHis += s;
	      }
	      else
	      {
	          System.out.println("\nSorry can't transfer. Insufficient balance");
	          System.out.println("Your current balance is : "+bal);
	      }
	}
	public static void main(String[] args)
	{
        Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ATM Interface!!!"+"\n"+"Please register");
		System.out.println("Enter Y/N if you are a new user:");
		char choice = input.next().charAt(0);
		if(choice == 'Y' || choice == 'y')
			register();
		System.out.println("Do you want to login?0/1:");
		int op = input.nextInt();
		if(op == 1)
		{
			if(login())
			{
				while(true)
				{
					System.out.println("Select any option to proceed:");
					System.out.println("1.WITHDRAW"+"\n"+"2.DEPOSIT"+"\n"+"3.CHECK BALANCE"+"\n"+"4.TRANSFER"+"\n"+"5.TRANSACTION HISTORY"+"\n"+"6.QUIT:");
					int ch = input.nextInt();
					switch(ch)
					{
						   case 1: withdraw();
						            break;
						   case 2: deposit();
					                break;
						   case 3: checkBal();
			                        break;
						   case 4: transfer();
			                        break;
						   case 5: tranHistory();
			                        break;
						   case 6: System.out.println("Please collect your card");
						            System.exit(0);
						   default:System.out.println("Enter a valid option!");   
					}
				}
			}
			else
			{
				System.out.println("Please collect your card");
		           System.exit(0);
			}
		}
		else
		{
			System.out.println("Please collect your card");
	           System.exit(0);
		}
	}
}