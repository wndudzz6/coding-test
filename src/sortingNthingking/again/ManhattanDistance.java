package sortingNthingking.again;

import java.util.ArrayList;
import java.util.Collections;

public class ManhattanDistance {
    public int solution(int[][] board){
        int answer=0;
        int n = board.length;
        //배열이 안된다. k가 몇 개인지 모르기 때문에
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col); //오름차순 정렬

        int x = row.get(row.size()/2);
        int y = col.get(col.size()/2);
        for(Integer p : row) answer += Math.abs(x-p);
        for(Integer p : col) answer += Math.abs(y-p);

        return answer;
    }

    public static void main(String[] args){
        ManhattanDistance T = new ManhattanDistance();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
