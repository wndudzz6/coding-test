package boj.hyndaeatuo.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//숨박꼭질
public class P1697 {
    static int[] dx = {-1, 1, 2};

    static int solution(int s, int e){
        int n = 100001;
        int[] dist = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while(!Q.isEmpty()){
            int cur = Q.poll();
            if(cur == e) {
                break;
            }
            for(int i = 0; i<3; i++){
                int nx;
                if(i == 2) nx = cur *2;
                else nx = cur+dx[i];

                if(nx>= 0 && nx<n && dist[nx] > dist[cur]+1){
                    dist[nx] = dist[cur]+1;
                    Q.offer(nx);
                }
            }

        }
        return dist[e];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        sc.close();

        System.out.println(solution(s,e));
    }
}
