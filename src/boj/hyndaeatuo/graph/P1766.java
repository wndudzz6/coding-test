package boj.hyndaeatuo.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//문제집
public class P1766 {

    static int[] solution(int n, int[] indegree, ArrayList<ArrayList<Integer>> graph){
        int[] answer = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer[idx++] = cur;

            for(int x : graph.get(cur)){
                indegree[x]--;
                if(indegree[x] == 0) pq.offer(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n+1];
        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i = 1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            indegree[b]++;
        }
        int[] answer = solution(n, indegree, graph);
        for(int x : answer) System.out.print(x+" ");
    }
}
