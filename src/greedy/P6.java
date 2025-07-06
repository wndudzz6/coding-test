package greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//6. 최대인원수 ~ 해법 듣고 재도전
//잘 안됨
public class P6 {
    public int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;
        Arrays.sort(bookings, (a, b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Arrays.sort(trains, (a, b)->a[0]-b[0]);
        int[] sum = new int[n+1]; //0~n 1based
        for(int i = 0; i < trains.length; i++){
            int s = trains[i][0];
            int e = trains[i][1];
            int k = trains[i][2];
            sum[s] +=k;
            sum[e] -=k;
        }
        for(int i = 1; i <= n; i++) sum[i] += sum[i-1];
        int idx = 0; //bookings 배열 인덱스
        Deque<Integer> dq = new LinkedList<>();
        for(int i =1; i <= n; i++) {

            //도착해서 내리는 어린이
            int dqSize = dq.size();
            for(int j = 0; j<dqSize; j++){
                int dest = dq.pollFirst();
                if(dest == i){
                    answer++;
                    sum[i]++;
                }else dq.offerLast(dest);
            }

            //이번 역에서 탈 수 있는 사람들 넣기
            while(idx < bookings.length && bookings[idx][0] == i){
                int dest = bookings[idx][1];

                if(sum[i]>0){
                    sum[i]--;
                    dq.offerLast(dest);
                }idx++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
