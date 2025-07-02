package sortingNthingking;

import java.util.PriorityQueue;

//7.최소 회의실 개수
//전반적으로 잘 짰지만 큐가 필수인 구조가 아님. 리스트로 할 수 있다고 생각했지만 그냥 큐로 구현했음
//객체보다는 int[][]가, 우선순위 큐보다는 리스트가, compareTo보다는 Comparator가 유리하다.
public class P7 {
    static class Room implements Comparable<Room>{
        int time;
        char s;
        Room(int t,char s){
            this.time = t;
            this.s = s;
        }
        public int compareTo(Room o){
            if(this.time == o.time) return this.s - o.s; //e먼저 넣기 ^&^ 경계 확인하기 ㅠㅠ
            else return this.time - o.time;
        }
    }
    public int solution(int[][] meetings){
        int answer = 0;
        int n = meetings.length;
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for(int i = 0; i <n; i++){
            pq.offer(new Room(meetings[i][0], 's'));
            pq.offer(new Room(meetings[i][1], 'e'));
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            Room room = pq.poll();
            if(room.s == 's') {
                cnt++;
            } else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        P7 T = new P7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
