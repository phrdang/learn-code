package com.omegarobotics.unit3.challenges;

import java.util.Scanner;

public class Statistics {

    public static void main(String[] args) {
        /*
        Ask user to enter prices until they want
        to quit. After the user quits, display
        the number of items, average price (if possible),
        and sample standard deviation of the prices
        (if possible). Make sure the standard deviation
        is only up to 2 decimal points of precision
        (use System.out.printf and %.2f).

        Example output 1:
        Enter the price, or -1 to quit: $4
        Enter the price, or -1 to quit: $5
        Enter the price, or -1 to quit: $6.45
        Enter the price, or -1 to quit: $-1
        Number of items: 3
        Average price is $5.15
        Standard deviation of prices is $1.23

        Example output 2:
        Enter the price, or -1 to quit: $5
        Enter the price, or -1 to quit: $-1
        Number of items: 1
        Average price is $5.00
        Cannot calculate standard deviation for one item

        Example output 3:
        Enter the price, or -1 to quit: $-1
        Number of items: 0
        No data entered. Cannot calculate statistics.

        Note: How to calculate sample standard deviation for this problem
        (since you don't know all the data at once)
        1. Keep a count of the number of items (e.g. numItems)
        2. Keep a running sum of each price squared (e.g. sumSquares)
            (ex. if the prices are 5, 6, and 1, the sum of each price squared
            is 25 + 36 + 1)
        3. Keep a running sum of each price (e.g. sumItems)
            (ex. if the prices are 5, 6, and 1, the sum is 12)
        4. Sample standard deviation will be:
        sqrt(  (numItems * sumSquares - sumItems * sumItems) / (numItems * (numItems - 1))  )
         */

        double sumItems = 0.0; // sum of the prices of each item
        int numItems = 0; // number of items
        double sumSquares = 0.0; // sum of each price squared

        boolean finished = false;

        Scanner input = new Scanner(System.in);

        do {
            // Prompt user for the price
            System.out.print("Enter the price, or -1 to quit: $");
            double price = input.nextDouble();

            // If user enters -1 right away, display error message and exit
            if (price == -1 && numItems == 0) {
                // Display total number of items
                System.out.println("Number of items: " + numItems);
                System.out.println(
                    "No data entered. Cannot calculate statistics."
                );
                finished = true;
                // Else if user enters a valid price, modify variables accordingly
            } else if (price != -1) {
                sumItems += price;
                numItems += 1;
                sumSquares += price * price;
                // Else (user enters -1 after entering at least 1 price),
                // exit the loop
            } else {
                // Display total number of items
                System.out.println("Number of items: " + numItems);

                // Calculate the average and display it
                double average = sumItems / numItems;
                System.out.format("Average price is $%.2f\n", average);

                // Display standard deviation
                // If user only entered 1 item, display error message
                if (numItems == 1) {
                    System.out.println(
                        "Cannot calculate standard deviation for one item."
                    );
                } else {
                    // Else, calculate and display the standard deviation
                    double standardDeviation = Math.sqrt(
                        (numItems * sumSquares - sumItems * sumItems) /
                        (numItems * (numItems - 1))
                    );
                    System.out.printf(
                        "Standard deviation of prices is $%.2f\n",
                        standardDeviation
                    );
                }

                finished = true;
            }
        } while (!finished);

        input.close();
    }
}
