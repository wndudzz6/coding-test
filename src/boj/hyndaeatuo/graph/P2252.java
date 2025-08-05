package boj.hyndaeatuo.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//줄세우기 (위상정렬)
public class P2252 {

    static int[] solution(int n, int m, ArrayList<ArrayList<Integer>> graph, int[] indegree){
        int[] answer = new int[n]; //answer 0 Based
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer[idx++] = cur;

            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) pq.offer(next);
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
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>()); //1based
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b); //a->b 검색
            indegree[b]++; //뒤에 서야 하는 애
        }

        int[] height = solution(n, m, graph, indegree);
        for(int x : height) System.out.print(x+" ");

    }
}
