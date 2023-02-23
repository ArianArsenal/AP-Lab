//import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        int array[] = {1,9,10,2,4};
        int x = 0;

        for(int i = 0; i < 4; i++){

            for (int j = 0; j < 4; j++){
                if (array[j+1] < array[j]) {

                    int temp;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    x = 1;
                }
            }
            if( x == 0){
                break;
            }
        }

        for(int i = 0; i < 5; i++){
            System.out.printf("%d",array[i]);
        }

        //System.out.println(array);


    }
}