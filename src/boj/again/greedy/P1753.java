package boj.again.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1753 {
    static class Edge implements  Comparable<Edge>{
        int v; //다음 정점
        int w; //가중치

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w); //가중치 오름차 정렬
        }
    }

    static int[] solution(int s, int v, ArrayList<ArrayList<Edge>> graph){
        //다익스트라
        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(dist[e.v] < e.w) continue;

            for(Edge next : graph.get(e.v)){
                if(dist[next.v] > next.w + e.w) {
                    dist[next.v] = next.w + e.w;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
        return  dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int s = sc.nextInt(); //시작 정점의 번호

        ArrayList<ArrayList<Edge>> graph = new  ArrayList<>();
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            graph.get(a).add(new Edge(b,w));
        }

        int[] answer = solution(s, v, graph);
        for(int i = 1; i<=v; i++){
            if(answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else {
                System.out.println(answer[i]);
            }
        }
    }
}
