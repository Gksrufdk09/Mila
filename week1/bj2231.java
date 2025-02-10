import java.util.*;
import java.util.Scanner;

public class  bj2231{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int result = 0;

 // 1부터 N-1까지 모든 숫자를 탐색 (브루트포스)       
		for(int i=0; i<n; i++){
            int number = i; 
            int sum = 0;  // i의 각 자리수의 합을 저장할 변수
                        
			//자리수 합 계산 (while 반복문)
            while (number != 0) { 
                sum += number%10; // 1의 자리 숫자를 sum에 더함
                number /= 10; // 자리수를 한 칸 줄임
            }


				//생성자 조건 확인 
            if(sum + i ==n){ // i의 분해합이 N과 같다면
                result = i;  // i는 N의 생성자
	              break; // 가장 작은 생성자를 찾았으므로 종료
            }
        }
	     // 결과 출력 (생성자가 없으면 0 출력) 
	    System.out.println(result);
    }
    
}
