package graph.again;

import java.util.*;

//위상정렬 이용
//인덱스를 잘 쓰는게 아주 중요함
public class EducationCourse {

    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        String[] answer = new String[n];
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i<n; i++) node.put(subjects[i], i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(String x : course){
            int a = node.get(x.split(" ")[0]); //후수
            int b = node.get(x.split(" ")[1]); //선수
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0) Q.offer(i);
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!Q.isEmpty()){
            int cur = Q.poll();
            order.add(cur);
            for(Integer x : graph.get(cur)){
                indegree[x]--;
                if(indegree[x] == 0) Q.offer(x);
            }
        }

        for(int i = 0; i<n; i++){
            answer[i] = subjects[order.get(i)];
        }
        return answer;
    }

    public static void main(String[] args) {
        EducationCourse T = new EducationCourse();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"english", "math", "physics", "art", "music"},
                new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));

    }
}
