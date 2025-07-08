package dfs;

//괜찮게 잘 짰지만 여러 명이랑 싸운 경우 마지막에 싸운 사람만 반영돼서 안됨
//fch를 1차원 배열에서 2차원 배열로 저장으로 바꿈
public class P2 {
    static int[][] fch;
    static int[] ch;
    static int[] arr;
    static int answer;

    void DFS(int l, int cn){ //cn 현재 고른거
        if(l == 7){
            answer++;
        }else{
            for(int i = 1; i<= 7; i++){
                if(fch[cn][i] == 0 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(l+1, i);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        fch = new int[8][8]; //7명이니까. 싸우기 체크
        ch = new int[8];

        for(int i = 0; i<fight.length; i++){
            int x = fight[i][0];
            int y = fight[i][1];
            fch[x][y] = 1;
            fch[y][x] = 1;
        }
        arr = new int[7];
        DFS(0, 0);



        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
