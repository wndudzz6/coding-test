package dp;

import java.util.Scanner;

//3. 계단오르기
//잘 안됨 누적형인거까진 떠올렸는데 점화식이 잘 안풀림
public class P3_2579 {

    static int solution(int n, int[] stairs){
        int[] dy = new int[n+1];
        dy[0] = 0; // 땅바닥
        dy[1] = stairs[0];
        dy[2] = stairs[1];
        for(int i = 3; i<=n; i++){
            dy[i] = Math.max(dy[i-2]+stairs[i-1], dy[i-3]+stairs[i-1]+stairs[i-2]);
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n];
        for(int i = 0; i<n; i++){
            stairs[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, stairs));
    }
}
