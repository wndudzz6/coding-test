package boj.august.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

//0-1 BFS
public class P13549_숨박꼭질3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 100001;
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int n = sc.nextInt();
        int k = sc.nextInt();

        dist[n] = 0;
        Deque<Integer> dq = new ArrayDeque<>(); //위치만 넣기
        dq.offerFirst(n);

        while(!dq.isEmpty()){
            int x = dq.pollFirst();
            int cost = dist[x];
            if(x == k) break;

            for(int nx : new int[] { x-1, x+1, 2*x }){
                if(nx<0 || nx>= N) continue;

                if(nx == 2*x && dist[nx] > cost){
                    dist[nx] = cost;
                    dq.offerFirst(nx);
                }else{
                    if(dist[nx] > cost+1){
                        dist[nx] = cost+1;
                        dq.offerLast(nx);
                    }
                }
            }
        }

        System.out.println(dist[k]);
    }
}
