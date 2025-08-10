package boj.hyndaeatuo.graph.again;

import java.util.*;

public class P2252 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;

    static int[] solution(){
        int[] answer = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) Q.offer(i);
        }

        int idx = 0;
        while(!Q.isEmpty()){
            int cur = Q.poll();
            answer[idx++] = cur;

            for(int x : graph.get(cur)){
                indegree[x]--;
                if(indegree[x] == 0) Q.offer(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        indegree = new int[n+1];
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // a->b
            indegree[b]++;
        }

        int[] answer = solution();
        for(int x : answer){
            System.out.print(x+" ");
        }
    }
}
