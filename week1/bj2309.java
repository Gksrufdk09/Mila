import java.util.*;

public class bj2309 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[]x = new int[9];

        int sum = 0;
        int a = 0;
        int b= 0;

        for( int i=0; i<x.length; i++){
            x[i] = s.nextInt();
            sum+= x[i];
        }

        Arrays.sort(x);

        for(int j=0; j<x.length; j++){
            for( int k= j+1; k<x.length; k++){
                if( sum-x[j] - x[k]==100){
                    a=j;
                    b=k;
                    break;
                }
            }
        }

        for(int t = 0 ; t<x.length; t++){
            if(t==a || t == b)
                continue;
                System.out.println(x[t]);
        }

    }
}
