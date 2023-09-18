import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //rad 8-11: användare välkomnas och alternativen presenteras
        System.out.println("Hello and Welcome! Please choose what you want to do:");
        System.out.println("1. Pay salary to employee/employees");
        System.out.println("2. Create a new invoice");
        System.out.println("3. pay invoice/invoices");
        System.out.println(" ");
        System.out.println("The account currently has 50000 sek");

        //Init variabel som styr user input (1,2 eller 3)
        int userAlt;

        //konto med 20k som används ihop med programmet
        int moneyAccount = 50000;

        //while loop med catch då programmet endast ska styras med siffror vill jag ha en catch
        while (true) {
            try {
                userAlt = myScanner.nextInt();

                if(userAlt == 1){
                    System.out.println("How many employees do you want to pay salary to?");




                } else if(userAlt == 2){
                    System.out.println("Insert invoice's value");
                    //ny int för att läsa user input och sedan använda för att beräkna moms och addera till account
                    int invoiceValue = myScanner.nextInt();
                    //nedan adderar vi fakturans värde till account
                    moneyAccount += invoiceValue;
                    //skapar ny int för att beräkna moms samt spara värdet för att kunna printa.
                    int vatInvoice;
                    //beräkna moms 25%
                    vatInvoice = ((invoiceValue * 25) / 100);

                    System.out.println("Total value of the invoice is: " + invoiceValue + " Sek");
                    System.out.println("Total value Tax (VAT) is: " + vatInvoice + " Sek");
                    System.out.println("Total value of invoice excluding VAT is: " + (invoiceValue - vatInvoice) + " Sek");
                    System.out.println(" ");
                    System.out.println("Total value of account is: " + moneyAccount + " Sek");

                    break;
                } else if(userAlt == 3){
                    System.out.println("Please write the number of invoices you want to pay.");
                    double payInvoice[];


                } else if(moneyAccount < 0){
                    System.out.println("You do not have enough money, total value of your account is: " + moneyAccount);
                }

            } catch (Exception e) {
                System.out.println("Wrong input, have to be a number.");
                myScanner.next();
            }
        }
    }
}