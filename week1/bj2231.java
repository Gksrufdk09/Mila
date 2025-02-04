import java.util.*;
import java.util.Scanner;

public class  Back_2231{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int result = 0;

        // 가장 기본적인 방법
        for(int i=0; i<n; i++){
            int number = i; 
            int sum = 0; 

            while (number != 0) { 
                sum += number%10; 
                number /= 10;
            }

            if(sum + i ==n){
                result = i;
                break;
            }
        }
    
        System.out.println(result);
    }
    
}
