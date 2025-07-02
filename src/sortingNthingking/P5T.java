package sortingNthingking;

import java.util.ArrayList;

//맨해튼 거리 ~ 내 코드에 비해 코드 짧고 깔끔, 수학적으로 정확하다
//장애물 없는 격자에서의 이동거리 = 맨해튼 거리
//맨해튼 거리 합이 최소가 되는 지점은 중앙값
public class P5T {
    public int solution(int[][] board){
        int answer=0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0; i< n; i++){
            for(int j= 0; j< n; j++){
                if(board[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a,b)->a-b); // row는 오름차순 정렬 굳이 안해도 된다고 함 알아서 정렬됨.
        int x = row.get(row.size()/2); //인덱스 중앙값을 꺼내자.
        int y = col.get(col.size()/2);
        for(int p : row) answer += Math.abs(x-p);
        for(int p : col) answer += Math.abs(y-p);

        return answer;
    }

    public static void main(String[] args){
        P5T T = new P5T();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
