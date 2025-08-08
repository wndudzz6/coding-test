package boj.hyndaeatuo.graph.again;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P2252 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static int n, m;

    static int[] solution(){
        int[] answer = new int[n];
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) PQ.offer(i);
        }
        int idx = 0;
        while(!PQ.isEmpty()){
            int cur = PQ.poll();
            answer[idx++] = cur;
            for(Integer next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) PQ.offer(next);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =sc.nextInt();
        graph = new ArrayList<>();
        indegree = new int[n+1];
        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i = 1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); //a->b
            indegree[b]++;
        }
        int[] order = solution();
        for(int x : order) System.out.print(x+" ");
    }
}
