package simulation;

import java.util.Arrays;

//회의실 만남 ~ 이해가 잘 안됨 발상까진 알겠는데 구현이 너무 헷갈림
public class P8T {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        //0based 변환
        for(int i = 0; i<n; i++){
            enter[i]--;
            exit[i]--;
        }

        //각 사람의 입장 인덱스 기록 enterIdx[i]는 사람이 enter 배열에서 언제 들어오는지 의미
        int[] enterIdx = new int[n];
        for(int i = 0; i<n; i++){
            enterIdx[enter[i]] = i;
        }

        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int cnt = 0;

        //각 사람의 입장 시간과 퇴장 시간 계산  ~ 중요 ~
        for(int i = 0, j= 0; i<n; i++){
            while(j<n && j<=enterIdx[exit[i]]){
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        int[] answer = new int[n];
        //만남 여부 계산
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(!(exitT[i] < enterT[j] || exitT[j]<enterT[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P8T T = new P8T();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
