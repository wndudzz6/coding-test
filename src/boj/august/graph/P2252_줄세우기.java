package boj.august.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {

    static int[] solution(int n, ArrayList<ArrayList<Integer>> graph, int[] indegree){
        Queue<Integer> Q = new LinkedList<>();
        int[] answer = new int[n];
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0){
                Q.offer(i);
            }
        }

        int idx = 0;
        while(!Q.isEmpty()){
            int cur = Q.poll();
            answer[idx++] = cur;

            for(Integer x : graph.get(cur)){
                indegree[x]--;
                if(indegree[x] == 0) Q.offer(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b); //a->b
            indegree[b]++;
        }
        sc.close();

        int[] answer = solution(n, graph, indegree);
        for(int x : answer) System.out.print(x+" ");
    }
}
