package dp.again;

import java.util.*;
//백준 수도 배관공사 P2
public class P2073 {

    static int solution(int d, int p, int[] L, int[] C){
        int[] dy = new int[d+1];
        //dy[i] : 길이i만큼 모았을 때 최대 용량

        //유한 냅색류 문제
        dy[0] = Integer.MAX_VALUE;
        for(int i = 0; i<p; i++){
            int l = L[i];
            int c = C[i];
            for(int j = d; j>=l; j--){
                if(dy[j-l]==0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j-l], c));
            }
        }
        return dy[d];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int[] L = new int[p];
        int[] C = new int[p];
        for(int i = 0; i<p; i++){
            L[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(d,p,L,C));
    }
}
