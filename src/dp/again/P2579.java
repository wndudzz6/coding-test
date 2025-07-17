package dp.again;

import java.util.Scanner;

public class P2579 {

    static int solution(int n, int[] stairs){
        int[] dy = new int[n+1];
        dy[1] = stairs[1];
        if(n>1) dy[2] = stairs[1]+stairs[2];
        for(int i = 3; i<=n; i++){
            dy[i] = Math.max(dy[i-2]+stairs[i], dy[i-3]+stairs[i-1]+stairs[i]);
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n+1];
        for(int i=1 ; i<=n; i++) stairs[i] = sc.nextInt();
        sc.close();
        System.out.println(solution(n, stairs));
    }
}
