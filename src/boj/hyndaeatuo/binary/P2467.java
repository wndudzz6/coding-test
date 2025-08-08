package boj.hyndaeatuo.binary;

import java.util.Scanner;

//용액
public class P2467 {

    static void solution(int n, long[] arr){
        long answer = Long.MAX_VALUE;
         long ltval = 0; long rtval= 0;
         int lt = 0; int rt = n-1;
         while(lt<rt){
             long sum = arr[lt]+arr[rt];
             if(Math.abs(sum) < Math.abs(answer)){
                 answer = sum;
                 ltval = arr[lt];
                 rtval = arr[rt];
             }
             if(sum<0) lt++;
             else rt--;
         }
        System.out.println(ltval+" "+rtval);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr= new long[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
    }
}
