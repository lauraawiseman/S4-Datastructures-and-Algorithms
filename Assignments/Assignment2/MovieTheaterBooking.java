package Assignment2;

import java.util.Scanner;

public class MovieTheaterBooking {
    // 2D array represents theater seating, 0 = available, 1 = reserved
    int[][] seats;

    // Constructor to initialize theater with given rows and columns
    public MovieTheaterBooking(int rows, int cols) {
        seats = new int[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                seats[r][c] = 0; 
    }

    // Checks if seat is available, if it is available(0), changes to reserved(1).
    public void reserveSeat(int row, int col){
        if (seats[row][col] == 0){
            seats[row][col] = 1;
            System.out.print("Success! Row " + row + ", Seat " + col + " reserved.");
        } else{
            // If seat is reserved, suggests next available seat
            suggestAvailableSeat();
        }
    }

    // Cancels a reservation if seat is reserved(1), resets back to available(0).
    public void cancelSeat(int row, int col) {
        if (seats[row][col] == 1){
            seats[row][col] = 0;
            System.out.println("Success! Reservation Row " + row + ", Seat " + col + " has been cancelled.");
        } else{
            System.out.println("Error! Seat is currently not reserved.");
        }
    }

    // Display seating chart, [S] = available seats, [X] = reserved seats
    public void displaySeatingChart(){
        for (int[] row : seats){
            for (int seat : row){
                System.out.print(seat == 0 ? "[S] " : "[X] ");
            }
            System.out.println();
        }
    }

    // Finds and prints first available seat in theater
    public void suggestAvailableSeat(){
        for (int r = 0; r < seats.length; r++){
            for (int c = 0; c < seats[0].length; c++){
                if (seats[r][c] == 0){
                    System.out.println("Seat already taken, try Row " + r + " Seat " + c);
                    return;
                }      
            }
        }
        System.out.println("No available seats.");
    }

    // Main menu loop
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MovieTheaterBooking theater = new MovieTheaterBooking(5, 5);
        int choice;

        do {
            System.out.println("\n --- Movie Theater Booking ---");
            System.out.println("\n1. View Seating Chart");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            // Input validation for menu choice must be an integer
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid Menu Option. Please enter a number between 1 and 4.");
                scanner.next();
                choice = -1;
                continue;
            }
            

        switch (choice) {
            case 1: 
                theater.displaySeatingChart();
                break;
            case 2: 
            // Prompt user for row and seat numbers to reserve
                System.out.println("Enter a row number to reserve: ");
                int row = scanner.nextInt();
                System.out.println("Enter a seat number to reserve: ");
                int col = scanner.nextInt();

                // Had to research this, instead of hardcoding the array length, it will pull from whats in the main loop. 
                if (row >= 0 && row < theater.seats.length && col >= 0 && col < theater.seats[0].length){
                    theater.reserveSeat(row, col);
                }else {
                    System.out.println("Invalid Row or Seat number. Please enter values between 0 and " + (theater.seats.length - 1) + " for the Rows and 0 and " + (theater.seats[0].length - 1) + " for Seats.");
                }
                break;
            case 3:
            // Prompt user for row and seat numbers to cancel
                System.out.println("Enter row number to cancel: ");
                row = scanner.nextInt();
                System.out.println("Enter seat number to cancel: ");
                col = scanner.nextInt();
                theater.cancelSeat(row, col);
                break;
            case 4: 
            // Exit the application
                System.out.println("GoodBye! Thank you for using the program.");
                break;
            default:
                System.out.println("Invalid Menu Choice. Please choose an option between 1 and 4");
                break;
        }
            
        } while (choice != 4);

        scanner.close();
    }

}