package boj.hyndaeatuo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//최소 비용 구하기
public class P1916 {
    static ArrayList<ArrayList<Bus>> graph;
    static int[] dist;

    static class Bus implements Comparable<Bus>{
        int d; //destination
        int c; //cost

        Bus(int d, int c){
            this.d = d;
            this.c = c;
        }

        public int compareTo(Bus o){
            return this.c-o.c;
        }
    }

    static int solution(int s, int e){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()){
            Bus cur = pq.poll();
            int vest = cur.d;
            int cost = cur.c;
            if(cost> dist[vest]) continue;
            for(Bus x : graph.get(vest)){
                int next = x.d;
                int nxcost = x.c;

                if(dist[next] > nxcost+cost){
                    dist[next] = nxcost+cost;
                    pq.offer(new Bus(next, nxcost+cost));
                }
            }
        }

        return dist[e];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //도시 개수 (정점)
        int m = sc.nextInt(); //버스 개수 (간선)

        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i = 1; i<=m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Bus(to, cost));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        System.out.println(solution(start, end));
    }
}
