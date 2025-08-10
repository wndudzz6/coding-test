package boj.hyndaeatuo.graph;

import java.util.*;

//최소 환승 경로
public class P2021 {
    static int n, l;

    static int solution(ArrayList<ArrayList<Integer>> graph, int s, int e){
        int[] ch = new int[l];
        HashMap<Integer, HashSet<Integer>> line = new HashMap<>();
        for(int i = 0; i<graph.size(); i++){
            for(int x : graph.get(i)){
                line.putIfAbsent(x, new HashSet<>());
                line.get(x).add(i);
            }//역에 노선 추가
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int curStop = Q.poll();
                for(int x : line.get(curStop)){
                    if(ch[x] == 1) continue;
                    ch[x] = 1;
                    for(int stop : graph.get(x)){
                        if(stop == e) return L;
                        Q.offer(stop);
                    }
                }
            }L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<l; i++){
            graph.add(new ArrayList<>());
            while(true){
                int station = sc.nextInt();
                if(station == -1) break;
                graph.get(i).add(station);
            }
        }
        int s = sc.nextInt();
        int e = sc.nextInt();
        sc.close();

        System.out.println(solution(graph, s, e));
    }
}
