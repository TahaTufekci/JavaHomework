import java.util.Scanner;
//Taha Tüfekçi ID:150119050
//The purpose of the program is to  
public class pro_fsdpjf {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String card_number = input.nextLine();
        for(int i = 0 ;i< card_number.length();i++)
            if(card_number.length() <= 1 || ((int)card_number.charAt(i) > 32 &&(int)card_number.charAt(i) < 48 )|| (int)card_number.charAt(i) > 57||(int)card_number.charAt(i) < 32 ) {
                System.out.print("Invalid Input !");
                System.exit(0);
            }
            else {

            }
        if(validateNumber(card_number))
            System.out.println("\nNumber is Valid");
        else
            System.out.println("\nNumber is Invalid");

    }
    public static boolean validateNumber (String number) {
        int i=0;
        char ch=number.charAt(i);
        String d_number = "";


        for( i = 0;i < number.length() ;i++) {

            if(ch != ' ') {
                number+=ch;
            }
        }
        for(i = number.length()-1; i >= 0;i--) {
            d_number += number.charAt(i);
        }
        String d_number1 =d_number;
        for(i = 0;i < number.length();i++) {
            d_number1 +='_' + d_number.charAt(i+1);

        }
        String l_number = d_number;
        for(i = 0;i < number.length();i=i+2) {
            if((int)(d_number.charAt(i)-'0')*2 > 9) {
                l_number+=(int)(d_number.charAt(i)-'0')*2-9;
            }
            else {
                l_number+=(int)(d_number.charAt(i)-'0')*2;
            }

        }
        String l_number1=d_number;
        String l_number2=d_number;
        for(i = 0;i < d_number.length();i++) {
            l_number1+=(int)(l_number.charAt(i+1)-'0')+(int)(d_number.charAt(i)-'0');
        }
        for(i = number.length()-1; i >= 0;i--) {
            l_number2+= l_number1.charAt(i);
        }
        int sum=0;
        for(i = 0;i < d_number.length();i++) {
            sum +=(int)(d_number.charAt(i)-'0')+(int)(l_number.charAt(i+1)-'0');

        }
        System.out.println("DNumber:"+d_number1);
        System.out.println("Lnumber:"+l_number2);


        if(sum % 10 == 0) {
            return true;

        }
        else{
            return false;
        }





    }
}
	
	