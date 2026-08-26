package y2026.programmers;

public class 지폐접기_PCCC기출_9번 {

    public static int solution(int[] wallet, int[] bill){
        int answer = 0;

        int x = wallet[0]; int y = wallet[1];
        int bx = bill[0]; int by = bill[1];

        while(true){
            if((x >= bx && y >= by) || (y>= bx && x >= by)) break;

            if(bx > by) bx = bx/2;
            else by = by/2;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};

        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};

        System.out.println(solution(wallet1, bill1));
        System.out.println(solution(wallet2, bill2));
    }
}
