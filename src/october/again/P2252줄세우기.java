package october.again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252줄세우기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] indegree = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //a -> b
            indegree[b]++;
            graph[a].add(b);
        }
        sc.close();

        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) Q.offer(i);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while(!Q.isEmpty()){
            int cur = Q.poll();
            answer.add(cur);

            for(Integer next : graph[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    Q.offer(next);
                }
            }
        }

        for(Integer x : answer) System.out.print(x+" ");
    }
}
