package dfs;

import java.util.ArrayList;
import java.util.Collections;

public class P1 {
    static boolean flag = false;
    static ArrayList<Integer> list;
    static int[] ch;
    static int answer = -1;

    void DFS(int l, int num, int n){
        if(flag) return;
        if(l == list.size()){
            if(num > n){
                answer = num;
                flag = true;
            }
        }else{
            for(int i = 0; i<list.size(); i++){
                if(ch[i] == 0){
                    ch[i] =1;
                    DFS(l+1, (num*10 + list.get(i)), n);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n){
        list = new ArrayList<>();
        int tmp  = n;
        while(tmp>0){
            list.add(tmp%10);
            tmp = tmp/10;
        }
        Collections.sort(list);
        ch = new int[list.size()];
        answer = -1;
        flag = false;
        DFS(0, 0, n);
        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
