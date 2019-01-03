package cl.ejercicios.treinta.dias.codigo;

import java.util.Scanner;

public class Day1DataTypes {
    
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        
        Scanner scan = new Scanner(System.in);
        
        int i2 = 0;
        double d2 = 0;
        String s2 = "";

        
        i2= Integer.parseInt(scan.nextLine());
        d2= Double.parseDouble(scan.nextLine());
        s2=scan.nextLine();
        
        
        
        System.out.println(i+i2);
        System.out.println(d+d2);
        System.out.println(s+s2);
        /* Declare second integer, double, and String variables. */

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        
        /* Print the sum of both integer variables on a new line. */

        /* Print the sum of the double variables on a new line. */
        
        /* Concatenate and print the String variables on a new line; 
            the 's' variable above should be printed first. */

        scan.close();
    }
}
