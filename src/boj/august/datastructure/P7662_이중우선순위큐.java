package boj.august.datastructure;

import java.util.*;

//PQ 혹은 Deque로 접근했음 (현재 Deque)
// 테스트케이스 시도 -> 틀림 / 이유 : 즉시 반영이 안됨 명령 한꺼번에 수행
//PQ : 정렬 즉시 반영 가능, 최댓값 뽑기 힘듦
//Deque : 정렬이 안됨, 최솟값 최댓값 뽑기 편함
//적절한 자료 구조 : TreeMap (몇 개 들어왔는지 카운트 가능, 정렬도 가능)
public class P7662_이중우선순위큐 {

    static void solution(ArrayList<Integer> in, ArrayList<Integer> cmd){
        in.sort((a,b)->a-b); //정렬
        Deque<Integer> dq = new ArrayDeque<>();
        for(int x : in){
            dq.offerLast(x);
        }

        for(int x : cmd){
            if(dq.isEmpty()){
                System.out.println("EMPTY");
                return;
            }

            //최솟값 삭제
            if(x == -1){
                dq.pollFirst();
            }else{
                dq.pollLast();
            }
        }

        if(!dq.isEmpty()){
            System.out.print(dq.peekLast()+" "+dq.pollFirst());
        }else{
            System.out.println("EMPTY");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t<T; t++){
            int k = sc.nextInt();
            ArrayList<Integer> in = new ArrayList<>();
            ArrayList<Integer> cmd = new ArrayList<>();
            sc.nextLine();
            for(int i = 0; i<k; i++){
                String x = sc.nextLine();
                char state = x.split(" ")[0].charAt(0);
                int n = Integer.parseInt(x.split(" ")[1]);
                if(state == 'I'){
                    in.add(n);
                }else{
                    cmd.add(n);
                }
            }
            solution(in, cmd);
        }
        sc.close();
    }
}
