package boj.again.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//특정한 최단 경로
public class P1504 {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int n, e;
    static final long INF = Long.MAX_VALUE/4;
    static class Edge implements Comparable<Edge>{
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w; //가중치 오름차순
        }
    }

    static long solution(int v1, int v2){
        long[] d1 = dikstra(1); //1->v1 or 1->v2
        long[] dv1 = dikstra(v1); //v1->v2 or v1->n
        long[] dv2 = dikstra(v2); //v2->n or v2->v2



        long order1 = d1[v1]+dv1[v2]+dv2[n]; //1->v1->v2->n
        long order2 = d1[v2]+dv2[v1]+dv1[n]; //1->v2->v1->n
        long answer = Math.min(order1, order2);

        return answer>=INF ? -1 : answer;
    }

    static long[] dikstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.w-b.w); //가중치 오름차순
        pq.offer(new Edge(start, 0));
        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int cv = cur.v,  cw = cur.w;
            if(dist[cv] < cw) continue;

            for(Edge next : graph.get(cv)){
                int nv = next.v, nw = next.w;
                if(dist[nv] > cw+nw){
                    dist[nv] = cw+nw;
                    pq.offer(new Edge(nv, cw+nw));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //1based
        e = sc.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i<=e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            //양방향 그래프
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        //임의의 두 정점
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        System.out.println(solution(v1, v2));
    }
}
