package graph;

public class P4T {
    public int solution(int[][] board) {
        int answer = 0;

        return answer;
    }

    public static void main(String[] args){
        P4T T = new P4T();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
