package boj.hyndaeatuo.sorting.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//모임장소 ~ 맨해튼 생각하고 풀긴 했는데
//중앙값은 왼쪽 오른쪽 상관없이 둘 다 옳으므로 짝홀수 구분없이 오른쪽 선택해도 된다고 함
public class MeetingPlace {
    public int solution(int[][] board){
        int answer=0;
        List<Integer> xlist = new ArrayList<>();
        List<Integer> ylist = new ArrayList<>();

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    xlist.add(i);
                    ylist.add(j);
                }
            }
        }
        Collections.sort(xlist);
        Collections.sort(ylist);

        int size = xlist.size();
        if((size%2) != 0 ){
            int midindex = size/2;
            int midx = xlist.get(midindex);
            int midy = ylist.get(midindex);
            for(int x : xlist) answer+=Math.abs(x-midx);
            for(int y : ylist) answer+= Math.abs(y-midy);


        }else{
            int a = size/2;
            int b = a+1;
            int midx = (xlist.get(a)+xlist.get(b))/2;
            int midy = (ylist.get(a)+ylist.get(b))/2;
            for(int x : xlist) answer+= Math.abs(x-midx);
            for(int y : ylist) answer+=Math.abs(y-midy);
        }

        return answer;
    }

    public static void main(String[] args){
        MeetingPlace T = new MeetingPlace();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
