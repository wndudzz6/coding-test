package boj.setember.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {

    static int[] solution(int n, ArrayList<ArrayList<Integer>> graph, int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[n];

        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int idx = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            answer[idx++] = cur;

            for(int next : graph.get(cur)){
                if(--indegree[next] == 0) q.offer(next);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n+1];

        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            indegree[b]++;
        }

        int[] order = solution(n, graph, indegree);
        for(int x : order) System.out.print(x+" ");
    }
}
