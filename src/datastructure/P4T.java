package datastructure;

import java.util.*;

public class P4T {
    int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60 + m;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList= new int[n][2];
        for(int i = 0; i<n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q =  new LinkedList<>();
        Q.offer(inList[0][1]); //첫 고객의 시술 종류 추가
        int fT = inList[0][0]; //첫 고객 입장시간 = 시뮬레이션 시작 시간
        int pos = 1; //다음 고객 인덱스
        for(int t = fT; t<=1200; t++){ //메인 반복 (시뮬레이션) 최대 20시까지
            if(pos<n && t == inList[pos][0]){ //새로운 고객 도착 확인 ~ 현재 시간이 어떤 고객의 입장 시간과 같다면
                if(Q.isEmpty() && t > fT) fT = t; //만약 큐가 비어있고 기계가 쉴 수 있는 상태라면 fT 갱신
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(t==fT && !Q.isEmpty()){ //기계가 동작할 시간인지 확인
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        P4T T = new P4T();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
