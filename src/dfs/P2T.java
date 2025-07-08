package dfs;

import java.util.Stack;

//사고 방식 자체는 동일 스택 쓴거만 다름 나는 cn이라는 인자로 직전 선택을 넘김
public class P2T {
    int[] ch;
    int[][] relation;
    int answer;
    Stack<Integer> pm;

    public void DFS(int L){
        if(L==7) answer++;
        else{
            for(int i = 1; i<8; i++){
                if(!pm.empty() && relation[pm.peek()][i]==1) continue;
                if(ch[i]== 0){
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L+1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }


    public int solution(int[][] fight){
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        for(int[] x: fight){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        P2T T = new P2T();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
