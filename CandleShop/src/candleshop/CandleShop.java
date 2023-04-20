/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package candleshop;

import java.util.Scanner;

/**
 * @author Sufian Azfar ITSC 1212-101, Long Version 1.1 Since 10/20/2022 Project
 * 3 Program designed for a shop owner/a customer at a candle shop to run
 * various calculations, and process customer transactions.
 */
public class CandleShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize 3 new candles using the candle constructor.
        //Initially, they will have any arbitrary value which will be replaced
        //with the user's input.
        Candle c1 = new Candle(" ", 0, 0.0, 0);
        Candle c2 = new Candle(" ", 0, 0.0, 0);
        Candle c3 = new Candle(" ", 0, 0.0, 0);

        //Welcome statement for the user//
        System.out.println("Welcome to the candle shop!");
        //Uses a scanner to prompt user to input candle name, type, etc.
        Scanner scnr = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            //Variables that will change given user's input.
            int typ = 0;
            double cst = 0.0;
            int brn = 0;
            String nameInput;
            System.out.println("Enter the name of candle " + i);
            nameInput = scnr.nextLine();
            //If statements to make sure that the proper name is assigned to each
            //candle.
            if (i == 1) {
                c1.setName(nameInput);
            } else if (i == 2) {
                c2.setName(nameInput);
            } else if (i == 3) {
                c3.setName(nameInput);
            }
            System.out.println("Enter the type of candle " + i);
            typ = scnr.nextInt();
            scnr.nextLine();
            //Similarly to earlier, use if statements to make sure the proper
            //type is assigned to each candle
            if (i == 1) {
                c1.setType(typ);
            } else if (i == 2) {
                c2.setType(typ);
            } else if (i == 3) {
                c3.setType(typ);
            }
            System.out.println("Enter the price of candle " + i);
            cst = scnr.nextDouble();
            scnr.nextLine();
            //Same thing as earlier, use if statements to ensure proper
            //assignment.
            if (i == 1) {
                c1.setCost(cst);
            } else if (i == 2) {
                c2.setCost(cst);
            } else if (i == 3) {
                c3.setCost(cst);
            }
            System.out.println("Enter the burn time, in minutes, of candle " + i);
            brn = scnr.nextInt();
            scnr.nextLine();
            if (i == 1) {
                c1.setTime(brn);
            } else if (i == 2) {
                c2.setTime(brn);
            } else if (i == 3) {
                c3.setTime(brn);
            }

        }
        //Now that we've exited the for loop, I can prompt users to enter the 
        //amount of candle of each type they'd like to purchase.
        int numCandles1;
        int numCandles2;
        int numCandles3;
        //Ask the user how many candles of each type they want, and save that
        //input to ints numCandles
        System.out.println("How many " + c1.getName() + " candles would you like?");
        numCandles1 = scnr.nextInt();
        scnr.nextLine();
        System.out.println("How many " + c2.getName() + " candles would you like?");
        numCandles2 = scnr.nextInt();
        scnr.nextLine();
        System.out.println("How many " + c3.getName() + " candles would you like?");
        numCandles3 = scnr.nextInt();
        scnr.nextLine();
        //Calculate the total cost of the customer's transaction before any
        //discounts are applied.
        double totalPreDiscount1 = numCandles1 * c1.getCost();
        double totalPreDiscount2 = numCandles2 * c2.getCost();
        double totalPreDiscount3 = numCandles3 * c3.getCost();
        double totalPreDiscount = totalPreDiscount1 + totalPreDiscount2 + totalPreDiscount3;
        //Use this conditional to evaluate what discount, if any, the customer
        //is eligible for. Use a variable, percentDiscount that changes based on 
        //the total price of the customer's transaction. If the customer is not
        //eligible for a discount, set the rate to 1. 
        double rateDiscount;
        if (totalPreDiscount > 20 && totalPreDiscount <= 35) {
            rateDiscount = .05;
        } else if (totalPreDiscount > 35 && totalPreDiscount <= 55) {
            rateDiscount = .07;
        } else if (totalPreDiscount > 55 && totalPreDiscount <= 100) {
            rateDiscount = .1;
        } else if (totalPreDiscount > 100) {
            rateDiscount = .2;
        } else {
            rateDiscount = 1;
        }
        //Finally, we can initiialize a variable for the total, including
        //discount, for the customer's transaction.
        double totalPostDiscount = totalPreDiscount - (rateDiscount * totalPreDiscount);
        //To find the total consecutive burn time of all the candles in the 
        //transaction, I can multiply the number of a given candle the customer
        //is buying by its burntime, and then add all of those together.
        double totalBurnTime = (numCandles1 * c1.getTime()) + (numCandles2 * c2.getTime()) + (numCandles3 * c3.getTime());
        double costPerMinute = totalPostDiscount / totalBurnTime;
        //Below are the statements that tell the customer the candles they
        //bought, the types, total price, etc.
        System.out.println(" ");
        System.out.println("-----TRANSACTION SUMMARY-----");
        System.out.println("Number of candles bought: " + (numCandles1 + numCandles2 + numCandles3));
        System.out.println("Names of candles: " + c1.getName() + ", " + c2.getName() + ", " + c3.getName());
        //An issue I found was that my costs were displaying to several decimal
        //places. I only wanted it to do 2 decimal places, so I rounded the values
        //to make the display more user friendly.
        System.out.println("Total price before discount: $" + (double) ((int) Math.round((totalPreDiscount * 100)) / 100));
        System.out.println("Total price after discount: $" + (double) ((int) Math.round((totalPostDiscount * 100)) / 100));
        System.out.println("Total burn time: " + totalBurnTime + " minutes.");
        System.out.println("Cost per minute: " + (double) ((int) Math.round((costPerMinute * 100))) / 100 + " dollars per minute.");
        System.out.println(" ");
        //Below is the code for this histogram that displays how many candles of
        //each type & name were purchased.
        System.out.println("Histogram of number purchased: ");
        //Bonus-Bonus: I used different symbols on the histogram for each candle
        System.out.print(numCandles1 + " type 1 candles: ");
        for (int i = 1; i <= numCandles1; i++) {
            System.out.print("*");
        }
        System.out.println("");
        System.out.print(numCandles2 + " type 2 candles: ");
        for (int i = 1; i <= numCandles2; i++) {
            System.out.print("#");
        }
        System.out.println("");
        System.out.print(numCandles3 + " type 3 candles: ");
        for (int i = 1; i <= numCandles3; i++) {
            System.out.print("@");
        }
        System.out.println(" ");
        System.out.println("-----TRANSACTION SUMMARY-----");

    }

}
