package boj.hyndaeatuo.binary;

import java.util.Arrays;
import java.util.Scanner;

//나무 자르기
public class P2805 {
    static int n, m;
    static int[] trees;

    static long can(int cap){
        long sum = 0;
        for(int x : trees){
            if(x>cap) sum+= x-cap;
        }
        return sum;
    }

    static int solution(){
        int lt = 1;
        int rt = trees[n-1];
        int answer = 0;

        while(lt<=rt){
            int mid = lt+ (rt-lt)/2;

            if(can(mid)>=m){
                answer = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        trees = new int[n];
        for(int i = 0; i<n; i++){
            trees[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(trees);
        System.out.println(solution());
    }
}
