package boj.hyndaeatuo.graph.lecture;

import java.util.*;

public class EduCourse {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String, Integer> subIndex = new HashMap<>();
        String[] answer = new String[n];

        for(int i =0; i<n; i++){
            subIndex.putIfAbsent(subjects[i], i);
        }

        //1. 그래프 & 진입 차수 배열
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n];

        //2. 간선 연결
        for(String c : course){
            String[] parts = c.split(" ");
            String after = parts[0];
            String before = parts[1];

            int a = subIndex.get(after);
            int b = subIndex.get(before);

            graph.get(b).add(a); // b->a (before->after)
            indegree[a]++;
        }
        //3. 위상정렬 ~ 사전순 고려
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer[idx++] = subjects[cur];

            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) pq.offer(next);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        EduCourse T = new EduCourse();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"english", "math", "physics", "art", "music"},
                new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
