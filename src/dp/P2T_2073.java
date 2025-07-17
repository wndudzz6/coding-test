package dp;

import java.util.*;

public class P2T_2073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int P = sc.nextInt();
        int[] dy = new int[D+1];
        for(int i = 0; i<P ; i++){
            int L = sc.nextInt();
            int C = sc.nextInt();
            for(int j = D; j>L; j--){
                if(dy[j-L] == 0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j-L], C));
            }
        }
        System.out.println(dy[D]);
    }
}
