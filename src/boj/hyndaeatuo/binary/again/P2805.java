package boj.hyndaeatuo.binary.again;

import java.util.Scanner;
import java.util.Arrays;

public class P2805 {
    static int n, m;
    static int[] tree;

    static int can(int cap){
        int sum = 0;
        for(int x : tree){
            if(x>cap) sum += (x-cap);
        }
        return sum;
    }

    static int solution(){
        Arrays.sort(tree);
        int answer = 0;
        int lt = 0;
        int rt = tree[n-1];

        while(lt<=rt){
            int mid = lt+(rt-lt)/2;
            if(can(mid) >= m){
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
        tree = new int[n];
        for(int i = 0; i<n; i++){
            tree[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution());
    }
}
