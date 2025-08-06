package boj.hyndaeatuo.BFS;

import java.util.*;

//숨박꼭질3
public class P13549 {
    static int[] dx = {-1, 1, 2};

    static int solution(int s, int e){
        Deque<Integer> dq = new ArrayDeque<>();
        int n = 100001;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        dq.offer(s);

        while(!dq.isEmpty()){
            int cur = dq.pollFirst();
            int cost = dist[cur];
            if(cur == e) return cost;

            for(int i = 0; i<3; i++){
                if(i==2){
                    int nx = cur * 2;
                    if(nx>=0 && nx<n && dist[nx] > cost){
                        dist[nx] = cost;
                        dq.offerFirst(nx);
                    }
                }else{
                    int nx = cur+dx[i];
                    if(nx>=0 && nx<n && dist[nx] > cost+1){
                        dist[nx] = cost+1;
                        dq.offerLast(nx);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        sc.close();
        System.out.println(solution(s,e));


    }
}
