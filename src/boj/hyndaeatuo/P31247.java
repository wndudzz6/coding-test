package boj.hyndaeatuo;

import java.util.Scanner;

//2024는 무엇이 특별할까?
//소인수분해 방법이 잘 안떠오름
//후에 다시 접근하기
public class P31247 {
    static long[] pow;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pow = new long[64];
        pow[0] = 1;
        for(int i = 1; i<=63; i++){
            pow[i] = pow[i-1]*2;
        }
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<t ; i++){
            long n = sc.nextLong();
            long k = sc.nextLong();

            if (k >= 63) {
                result.append(0).append("\n");
            }else{
                int tmp = (int) k;
                long ans = n/pow[tmp];

                if(ans % 2 == 0){
                    result.append(ans/2).append("\n");
                }else{
                    result.append(ans-(ans-1)/2).append("\n");
                }
            }
        }
        System.out.println(result.toString());
    }

}
