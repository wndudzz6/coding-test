package boj.september.graph;

import java.util.*;

public class P1753_최단경로 {
    static class Edge implements Comparable<Edge>{
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

    static int[] solution(ArrayList<ArrayList<Edge>> graph, int s, int v, int e){
        int[] dist = new int[v+1]; // 1based
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));


        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.w > dist[cur.v]) continue;

            for(Edge o : graph.get(cur.v)){
                if(dist[o.v] > cur.w+o.w){
                    dist[o.v] = cur.w+o.w;
                    pq.offer(new Edge(o.v, cur.w+o.w));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();//정점 개수
        int e = sc.nextInt();//간선 개수

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i<=v; i++) graph.add(new ArrayList<>());

        int s = sc.nextInt(); //시작 정점

        for(int i = 0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b,c));
        }


        int[] answer = solution(graph, s, v, e);
        for(int i = 1; i<=v; i++){
            if(answer[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(answer[i]);
        }
    }
}
