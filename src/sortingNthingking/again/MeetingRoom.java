package sortingNthingking.again;

import java.util.ArrayList;

public class MeetingRoom {
    public int solution(int[][] meetings){
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings) {
            list.add(new int[]{x[0], 1}); //회의 시작 1
            list.add(new int[]{x[1], 0}); //회의 끝 0
        }
        list.sort((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); //시간 오름차순[0]인데 같은 경우에 끝부터

        int cnt = 0;
        for(int[] x : list){
            if(x[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        MeetingRoom  T = new MeetingRoom ();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
