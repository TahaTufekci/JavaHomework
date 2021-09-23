import java.util.Scanner;

    // TAHA TÜFEKÇİ ID:150119050
    // The purpose of this code is to calculate the compound monthly interest
    public class Pro1_150119050{
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Enter number of days
        System.out.print("Number of days:");
        int day = input.nextInt();

        // Obtain year, month and days left
        int years = day / 365;
        int months = (day % 365) / 31 ;
        int days_left = (day % 365) % 31;

        // Display results
        System.out.print("Year: " + years + ",");
        System.out.print(" Month: " + months + ",");
        System.out.print(" Day: " + days_left);

    }
}

