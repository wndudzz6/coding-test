package dp;

import java.util.Scanner;

//6. 수확 ~ 구간 기반 DP
public class P6_1823 {

    static int solution(int n, int[] arr){
        int lt = 1; int rt = n;
        int step = 1;
        int sum = 0;
        while(true){
            if(step == n+1){
                break;
            }
            if(arr[lt]>arr[rt]){
                sum+=step*arr[rt];
                rt--;
            }else{
                sum+=step*arr[lt];
                lt++;
            }
            step++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, arr));
    }
}
