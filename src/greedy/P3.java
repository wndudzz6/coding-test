package greedy;

import java.util.Arrays;
//잘 안떠올라서 풀이보고 코드 짰음 ~ 확장하는 방식이 그리디가 아니라 틀린 로직
public class P3 {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] cooler = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            int k = nums[i];
            int s = i-k;
            int e = i+k;
            if(s<0) s = 0; if(e>n) e=n;
            cooler[i][0] = s;
            cooler[i][1] = e;
        }
        Arrays.sort(cooler, (a,b)-> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

        if(cooler[0][0] != 0) {
            return -1;
        }
        answer++;
        int s = 0;
        int e = cooler[0][1];

        for(int i = 1; i <= n; i++){
            int cs = cooler[i][0];
            int ce = cooler[i][1];

            if(e == n) return answer;
            if(i==n){
                if(e<n) return -1;
            }

            if(s==cs) {
                s=cs; e = ce;
            }else if(e>=cs && e<ce){
                answer++;
                s = cs; e = ce;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        P3 T= new  P3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
