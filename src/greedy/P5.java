package greedy;

import java.util.Arrays;

//O(n^2)이라 효율성 테스트에서 부족하다.
public class P5 {
    public int[] solution(String[] students){
        int n = students.length;
        int[][] games = new int[n][3];
        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            games[i][0] = i;
            String team = students[i].split(" ")[0];
            games[i][1] = team.charAt(0) - 'a';
            games[i][2] = Integer.parseInt(students[i].split(" ")[1]);
        }
        Arrays.sort(games, (a, b)->b[2]-a[2]); // 점수 기준 내림차 정렬
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
                if(games[i][1] != games[j][1] && games[i][2]>games[j][2]) sum+=games[j][2];
            }
            answer[games[i][0]] = sum;
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
