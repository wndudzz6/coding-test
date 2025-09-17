package kakao.비트마스크;

import java.util.*;

public class 비밀지도 {
    // 풀이 함수
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int v = arr1[i] | arr2[i];       // 두 줄 OR
            StringBuilder sb = new StringBuilder(n);
            for (int k = n - 1; k >= 0; k--) // MSB -> LSB
                sb.append(((v & (1 << k)) != 0) ? '#' : ' ');
            answer[i] = sb.toString();
        }
        return answer;
    }

    // 실행용 main (psvm)
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = solution(n, arr1, arr2);

        // 한 줄로 확인
        System.out.println(Arrays.toString(result));
        // 문제 출력 형식처럼 줄단위 확인
        for (String line : result) System.out.println(line);
    }
}
