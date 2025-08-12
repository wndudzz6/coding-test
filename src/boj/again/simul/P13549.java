package boj.again.simul;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P13549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int N = 100001;
        int[] cost =  new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();//0-1BFS
        dq.offer(n);
        cost[n] = 0;

        while (!dq.isEmpty()) {
            int x =  dq.poll();
            int xc = cost[x];

            if(x == k) break;

            for(int nx : new int[]{x+1, x-1, x*2}){
                if(nx>=0 && nx<N){
                    if(nx == x*2){
                        if(cost[nx] > xc){
                            cost[nx] = xc;
                            dq.offerFirst(nx);
                        }
                    }else{
                        if(cost[nx] > xc+1){
                            cost[nx] = xc+1;
                            dq.offerLast(nx);
                        }
                    }
                }
            }
        }

        System.out.println(cost[k]);

    }
}
