package dfs;

import java.util.ArrayList;

public class P3 {
    static int answer, n;
    static int[] ch;

    //n은 cans.length;
    public void DFS(int l, int s, int[][] cans){
        if(l== n/2){
            ArrayList<Integer> W = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(ch[i] == 0) W.add(cans[i][0]);
                else B.add(cans[i][1]);
            }
            int Wsum = 0, Bsum=0;
            for(int x : W) Wsum+=x;
            for(int x : B) Bsum+=x;
            answer = Math.min(answer, Math.abs(Wsum-Bsum));
        }else{
            for(int i = s; i<n; i++){
                ch[i] = 1;
                DFS(l+1, i+1, cans);
                ch[i]= 0;
            }
        }
    }

    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        n = cans.length;
        ch = new int[n];
        DFS(0,0, cans);
        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
