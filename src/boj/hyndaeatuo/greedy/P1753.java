package boj.hyndaeatuo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//최단 경로 다익스트라
public class P1753 {
    static int v,e,s;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph;
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o){
            return this.w-o.w;
        }
    }

    static void solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v,0));
        dist[v] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.v;
            int w = tmp.w;
            if(w>dist[now]) continue;
            for(Edge next : graph.get(now)){
                if(w + next.w < dist[next.v]  ){
                    dist[next.v] = w+next.w;
                    pq.offer(new Edge(next.v, w+next.w));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();//입력받을 간선 개수
        s = sc.nextInt();//시작정점의 번호
        graph = new ArrayList<>();
        for(int i = 0; i<=v; i++) graph.add(new ArrayList<>());
        for(int i = 1; i<=e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            graph.get(from).add(new Edge(to,w));
        }
        dist= new int[v+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        solution(s);
        for(int i = 1; i<=v; i++){
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }else System.out.println(dist[i]);
        }
    }
}
