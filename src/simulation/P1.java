package simulation;

import java.util.Arrays;

//사다리 타기
public class P1 {

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n]; //모든 학생이 사다리를 탄 결과.
        int [] indexs = new int[n+1];
        for(int i = 1; i <= n; i++){
            indexs[i] = i;
        }

        for(int k = 1; k <= n; k++){
            int ori = indexs[k];//현재 가고 있는 학생의 원래 인덱스
            int cur = indexs[k];

            for(int i = 0; i<ladder.length; i++){
                for(int j = 0; j<ladder[i].length; j++){
                    int x = ladder[i][j]; //지금 고려하는 사다리
                    if(cur == x && cur>0 && cur<=n){
                        cur ++;
                    }else if(cur == x+1 && cur<=n){
                        cur--;
                    }
                }
            }answer[cur-1] = (char)('A'+ori-1);
        }


        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
