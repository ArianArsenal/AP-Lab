import java.util.Scanner;


public class Gcd_lcmJava{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter First Number :\n");

        int a = scanner.nextInt();

        System.out.printf("Enter Number Number :\n");
        int b = scanner.nextInt();

        int c = b;
        int d = a;
        int temp;
	    while(b != 0){
		    temp = a % b;	
		    a = b;
		    b = temp;
        }
        int gcd = a;

        //zarb / gcd
        
        double lcm = (d * c) / (gcd + 0.0);


        


        System.out.printf("GCD is : %d\n",gcd);
        System.out.printf("LCM is : %2.2f\n",lcm);

        scanner.close();

	}

    }
