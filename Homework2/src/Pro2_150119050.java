import java.util.Scanner;

// TAHA TÜFEKÇİ ID:150119050
// The purpose of this code is to calculate the compound monthly interest
public class Pro2_150119050{
        public static void main(String[] args) {
            // Create a Scanner
            Scanner input = new Scanner(System.in);

            // Enter initial principle balance
            System.out.print("Enter initial principle balance:");
            double InitialPrincipleBalance = input.nextDouble();

            // Enter yearly interest rate
            System.out.print("Enter yearly interest rate (Exp:9.45):");
            double InterestRate = input.nextDouble();

            // Enter montly time periods
            System.out.print("Enter montly time periods(Exp:8):");
            double TimePeriod = input.nextDouble();

            // Calculate final amount
            double TotalAmount = InitialPrincipleBalance * (Math.pow(1 + (InterestRate / (12 * 100)),  TimePeriod));

            // Display results
            System.out.println("Initial balance:"+ InitialPrincipleBalance );
            System.out.println("Monthly interest rate:" +(int)((InterestRate / 12) * 100) / 100.0);
            System.out.println("Total compound interest:"+ (int)((TotalAmount - InitialPrincipleBalance) * 100) / 100.0);
            System.out.println("Final balance:"+ (int)(TotalAmount * 100) / 100.0);

        }
}