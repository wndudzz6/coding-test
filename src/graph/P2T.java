package graph;

import java.util.*;

//HashMap으로 graph를 만든거부터가 포인트임 0based 신경쓸 필요없고 역이 불규칙적으로 있어도 노상관
//graph를 만들 때는 키, 값을 항상 고려해야 됨.
//최소 환승 횟수를 구해야 하므로 노선을 중심으로 BFS가 레벨을 확장하게 해야하고 사람은 역끼리 이동하니까
//체크는 노선, 큐에 들어가는 것은 역, 이동하는 경로를 결정하는 것도 노선
//따라서 역으로 노선을 체크해야하므로 키 : 역 값 : 노선
public class P2T {
    public int solution(int[][] routes, int s, int e){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        for(int i = 0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<>());
                graph.get(x).add(i);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[n];
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int curStop = Q.poll();
                for(int line : graph.get(curStop)){
                    if(ch[line] == 1) continue;
                    ch[line] = 1;
                    for(int stop : routes[line]){
                        if(stop == e) return L;
                        Q.offer(stop);
                    }
                }
            }L++;
        }

        return -1;
    }

    public static void main(String[] args){
        P2T T = new P2T();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
