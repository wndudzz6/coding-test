package sortingNthingking;

import java.util.ArrayList;

//7.최소 회의실 개수
public class P7T {
    public int solution(int[][] meetings){
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings){
            list.add(new int[]{x[0], 1}); //1 : 시작
            list.add(new int[]{x[1], 2}); //2 : 끝
        }

        list.sort((a,b) -> a[0]== b[0] ? b[1]-a[1] : a[0]-b[0]); //[0]오름차 [0]이 같다면 내림차(끝부터)
        int answer = 0, cnt = 0;
        for(int[] x : list){
            if(x[1] == 1) cnt++; //시작일 때 ++
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        P7T T = new P7T();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
