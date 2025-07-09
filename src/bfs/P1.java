package bfs;

import java.util.*;

//잘 안됨
public class P1 {
    static class Jump{
        int jump;
        int index;
        Jump(int jump, int index){
            this.jump = jump;
            this.index = index;
        }
    }
    static int answer;
    public int BFS(int[] nums){
        Queue<Jump> queue = new LinkedList<>();
        int n = nums.length;
        int[] ch = new int[n];
        int s = nums[0];
        ch[0] = 1;
        queue.add(new Jump(s, 0));
        while(!queue.isEmpty()){
            Jump tmp = queue.poll();
            int jump = tmp.jump;
            int index = tmp.index;
            if(index == n-1){
                return answer;
            }
            for(int i = 1; i<=jump; i++){
                if(ch[index+i] == 0){
                    ch[index+i] = 1;
                    queue.add(new Jump(nums[index+i],index+i));
                }
            }
        }
        return answer;
    }

    public int solution(int[] nums){
        answer = -1;
        BFS(nums);
        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
