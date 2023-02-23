import java.util.Scanner;


public class Binary{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        //clear console in java
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while(true){
            
            int menu;

            System.out.printf("=========\nChoose Menu :\n");
            System.out.printf("1. Convert Binary to Decimal\n");
            System.out.printf("2. Convert Decimal to Binary\n");
            System.out.printf("3. Exit\n=========\n");
            
            menu = scanner.nextInt();

            if(menu == 1)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("Enter Your Number:");
                int binary = scanner.nextInt();
                int decimal = 0;
                int i = 0;
                while(binary != 0)
                {
                    decimal += (binary % 10) * Math.pow(2, i);
                    binary = binary / 10;
                    i++;
                }
                System.out.printf("Decimal Number is: %d\n", decimal);
                
            }
            
            else if(menu == 2)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                //change decimal to binary
                System.out.printf("Enter Your Number:");
                int decimal = scanner.nextInt();
                int binary = 0;
                int i = 1;
                while(decimal != 0)
                {
                    binary += (decimal % 2) * i;
                    decimal = decimal / 2;
                    i = i * 10;
                }
                System.out.printf("Binary Number is: %d\n", binary);
                
            }

            else if(menu == 3)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("Good Bye");
                break;
            }


        }
        
        scanner.close();
    }



    
}