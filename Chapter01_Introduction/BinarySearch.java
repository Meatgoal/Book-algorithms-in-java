package com.mycompany.binarysearch;

import java.util.Scanner;

/**
 * BinarySearch.java
 *
 * A simple interactive demonstration of the binary search algorithm.
 * The computer tries to guess the number the user has chosen by asking
 * whether the number is "smaller", "bigger", or "yes" (correct).
 *
 * Author: [Your Name]
 * Date: [Insert Date]
 */
public class BinarySearch {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        
        // Define the search range
        int low = 1;    // lowest possible number
        int high = 0;   // highest number defined by the user
        String choice;  // stores the user's response
        
        // Ask the user to define the upper limit of the range
        System.out.println("What will be the biggest number?");
        
        // Validate user input to ensure it's an integer
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next(); // discard invalid input
        }
        
        // Read the upper limit
        high = sc.nextInt();
        sc.nextLine(); // clear the buffer
        
        // Initial instructions
        System.out.println("Choose a number between 1 and " + high + ".");
        System.out.println("I will try to guess the number you chose!");
        
        // Main binary search loop
        // Continues while there is still a valid range
        while (low <= high) {
            // Calculate the middle point of the current range
            int mid = (low + high) / 2;
            
            // Ask the user if this is their number
            System.out.println("Is your number " + mid + "? (yes / smaller / bigger)");
            
            // Read and normalize the user's input
            choice = sc.nextLine().trim().toLowerCase();
            
            // If the guess is correct
            if (choice.startsWith("y")) {
                System.out.println("You see? This is the power of binary search!");
                break;
            }
            // If the number is smaller than the guess
            else if (choice.startsWith("s")) {
                high = mid - 1;
            }
            // If the number is bigger than the guess
            else if (choice.startsWith("b")) {
                low = mid + 1;
            }
            // If the user entered something invalid
            else {
                System.out.println("Error: please type yes, smaller, or bigger.");
            }
        }

        // If the loop ends without finding the number
        if (low > high) {
            System.out.println("Hmm... something doesn’t add up. Did you follow the rules? hahaha");
        }

        // Close the scanner (good practice)
        sc.close();
    }
}
