package boj.september.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1766_문제집 {

    static int[] solution(int n, ArrayList<Integer>[] graph, int[] indegree){
        int[] answer = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer[idx++] = cur;

            for(int next : graph[cur]){
                if(--indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        for(int i = 0; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            indegree[b]++;
        }
        sc.close();

        int[] answer = solution(n, graph, indegree);
        for(int x : answer) System.out.print(x+" ");
    }
}
