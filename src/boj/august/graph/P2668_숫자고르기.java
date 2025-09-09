package boj.august.graph;

import java.util.*;

//기본적인 풀이 DFS / 위상정렬 이용 코드
public class P2668_숫자고르기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] to = new int[n+1];
        int[] indegree = new int[n+1];
        for(int i = 1; i<=n; i++){
            to[i] = sc.nextInt();
            indegree[to[i]]++; //진입차수 계산
        }
        sc.close();

        //진입차수 0인 정점부터 제거
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        boolean[] removed = new boolean[n+1];
        while(!q.isEmpty()){
            int u = q.poll();
            removed[u] = true;
            int v = to[u]; //u는 사이클이 아님
            if(--indegree[v] == 0) q.offer(v);
        }

        //남은 정점(removed == false)이 사이클에 포함
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(!removed[i]) ans.add(i);
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int x : ans) System.out.println(x);
    }
}
