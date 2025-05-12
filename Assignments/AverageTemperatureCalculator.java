package Assignments;

import java.util.Scanner;

public class AverageTemperatureCalculator {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days: ");
        // Get user to input number of days
        int numDays = scanner.nextInt();

        // Create array using numDays assigned by user
        double[] temp = new double[numDays]; 
        double totalTemp = 0.0;

        // Loop through each day for temp
        for (int i = 0; i < numDays ; i++ )
        {
            System.out.println("Enter the temperature of day " + (i + 1) + ": ");
            temp[i] = scanner.nextDouble(); 
        }

        for (int i = 0; i < numDays ; i++)
        {
            totalTemp += temp[i];
        }
       
        scanner.close();

        // Days above average
        double avgTemp = totalTemp / temp.length;
        int daysAboveAvg = 0;

        for (int i = 0; i < temp.length; i++){
            if (temp[i] > avgTemp){
                daysAboveAvg++;
            }
        }
        
        System.out.println("Number of days: " + temp.length);
        System.out.printf("Average temperature for set number of days: " + (totalTemp/temp.length));
        System.out.println("Number of days temperature is above average: " + daysAboveAvg);
    }
}
