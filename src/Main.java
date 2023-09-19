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
        System.out.println("The account currently has 20000 sek");

        //Init variabel som styr user input (1,2 eller 3)
        int userAlt;

        //konto med 20k som används ihop med programmet
        int moneyAccount = 20000;

        //while loop med catch då programmet endast ska styras med siffror vill jag ha en catch
        while (true) {
            try {
                userAlt = myScanner.nextInt();

                if (userAlt == 1) {
                    System.out.println("How many employees do you want to pay salary to?");
                    int myEmployees = myScanner.nextInt();
                    //först måste user ange hur många som ska få lön
                    //sen skapar jag en array där medarbetare samlas i som jag sen kan använda
                    double[] employeeArray = new double[myEmployees];
                    //en for-loop som man anger varje anställds lös som ska betalas
                    for (int i = 0; i < employeeArray.length; i++) {
                        System.out.println("Type in the salary of employee: " + (i + 1));
                        double salaryWithTax = myScanner.nextDouble();
                        //beräkna lön efter 30% skatt
                        double salaryExTax = salaryWithTax * 0.7;
                        employeeArray[i] = salaryExTax;
                    }
                    //nedan en till loop som använder array:en för att printa ut allas löner
                    System.out.println("Salary employee: ");
                    for (int i = 0; i < employeeArray.length; i++) {
                        System.out.println("Employee " + (i + 1) + ": " + employeeArray[i] + "Sek.");
                    }
                    break;


                } else if (userAlt == 2) {
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
                } else if (userAlt == 3) {

                    //alternativ 3 kommer jag att göra på ungefär samma sätt som alternativ 1, därför kopierar jag-
                    //-en del kod från alt 1 och använder här nedan i alt 3

                    System.out.println("Please write the number of invoices you want to pay.");

                    int myInvoice = myScanner.nextInt();
                    //först måste user ange hur många fakturor ska betalas
                    //sen skapar jag en array där fakturorna samlas i
                    double[] invoiceArray = new double[myInvoice];
                    //en for-loop som man anger varje anställds lös som ska betalas
                    System.out.println("Type in the amount of invoice's you want to pay: ");
                    for (int i = 0; i < invoiceArray.length; i++) {
                        System.out.println("Type in the amount of invoice nr:  " + (i + 1) + ".");
                        if (moneyAccount > 0) {
                            double myNewInvoice = myScanner.nextDouble();

                            //om det fakturan är lägre summa än vad som finns på kontot så drar den av den summan från kontot
                            if (moneyAccount >= myNewInvoice) {
                                moneyAccount -= myNewInvoice;
                                System.out.println("konto efter avdrag: " + moneyAccount);
                            } else if (moneyAccount < myNewInvoice) { //om det inte finns tillräckligt med pengar så kan man inte betala fakturan
                                System.out.println("Sorry, you dont have enough money...");
                                System.out.println("Your account value is: " + moneyAccount);
                            }

                        } else if (moneyAccount < 1) {// om man inte har några pengar (vilket aldrig kommer hända i detta programmet) så kan man inte betala några fakturor.
                            System.out.println("You don't have enough money to pay salary.");
                            break;
                        }
                    }
                    //när alla fakturor är betalda avslutas programmet
                    break;

                } else if (userAlt == 0) {
                    break;
                }


                //om man inte skriver en siffra eller ett tal så hamnar man här och får chansen att skriva något annat
            } catch (Exception e) {
                System.out.println("Wrong input, have to be a number.");
                myScanner.next();
            }
        }
    }
}