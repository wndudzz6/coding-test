package boj.september.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬 접근
public class P9466_텀프로젝트 {

    //사이클이 아니면 모두 포함
    //선택받았을지라도 사이클이 아니면 의미가 X
    static int solution(int n, int[] to, int[] indegree){
        int cnt = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0){
                Q.offer(i);
            }
        }

        while(!Q.isEmpty()){
            int cur = Q.poll();
            cnt++;

            int x = to[cur];
            if(--indegree[x] == 0) Q.offer(x);

        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            int[] to = new int[n+1];
            int[] indegree = new int[n+1];
            for(int i = 1; i<=n; i++){
                to[i] = sc.nextInt();
                indegree[to[i]]++;
            }
            System.out.println(solution(n, to, indegree));
        }
        sc.close();
    }
}
