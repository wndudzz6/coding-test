package greedy;

import java.util.Scanner;

//잃어버린 괄호
public class P1541 {

    static int solution(String x){
        int sum = Integer.MAX_VALUE;
        String[] sub = x.split("-");
        for(int i = 0; i<sub.length; i++){
            int tmp = 0;

            //+ 사용시 escape필수 \\+
            String[] addition = sub[i].split("\\+");

            for(int j = 0; j<addition.length; j++){
                tmp+=Integer.parseInt(addition[j]);
            }

            if(sum == Integer.MAX_VALUE){ //처음에 더하기처리
                sum = tmp;
            }else{
                sum-=tmp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        sc.close();
        System.out.println(solution(x));
    }
}
