
import java.util.Scanner;

public class AtmMachine{

    private static Scanner sc;
    private static float balance = 0; // initial balnace 0 for everyone
    private static int anotherTransaction;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        transaction();
    }

    private static void transaction(){
        int choice;

        System.out.println("Please select an option");
        System.out.println("1. Withdrwal");
        System.out.println("2. Deposit");
        System.out.println("3. Balance Inquiry");

        choice = sc.nextInt();

        switch(choice){
            case 1: 
                float amount;
                System.out.println("Please enter amount to withdraw");
                amount = sc.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println("You have insufficient balance to perform this action.\n\n");
                    anotherTransaction();
                } else{
                    balance -= amount;
                    System.out.println("You have withdrawn" + amount + " and your updated balance is: " +balance+ "\n");
                    anotherTransaction();
                }                
            break;

            case 2:
                float deposit;
                System.out.println("Please enter amount you want to deposit in your account: ");
                deposit = sc.nextFloat();
                balance += deposit;
                System.out.println("You have deposited "+ deposit + "and your updated balance is: "+balance+"\n");
                anotherTransaction();
            break;

            case 3: 
                System.out.println("Your balance is: " + balance + "\n");
                anotherTransaction();
            break;

            default: 
                System.out.println("Invalid option\n\n");
                anotherTransaction();
            break;
        }
    }

    private static void anotherTransaction(){
        System.out.println("Do you want to make another transaction?\n\nPress 1 for another transaction\n2 to exit");
        anotherTransaction = sc.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thank you for choosing us!");
        } else{
            System.out.println("Invalid Choice\n\n");
            anotherTransaction();
        }
    }
}