package kakao.파싱;

import java.util.*;
import java.util.regex.*;

//9.18 일단 while 기준 공부 시간나면 정규식도 해보자
public class 다트게임정규식 {
    public static int solution(String dartResult) {
        int[] scores = new int[3];
        int round = 0;

        // (숫자 1~2자리)(보너스)(옵션?)
        Pattern p = Pattern.compile("(\\d{1,2})([SDT])([*#]?)");
        Matcher m = p.matcher(dartResult);

        while (m.find()) {
            int score = Integer.parseInt(m.group(1)); // 숫자
            char bonus = m.group(2).charAt(0);        // S, D, T
            String option = m.group(3);               // *, #, or ""

            // 보너스 처리
            if (bonus == 'D')      score = score * score;
            else if (bonus == 'T') score = score * score * score;

            // 옵션 처리
            if (option.equals("*")) {
                score *= 2;
                if (round > 0) scores[round - 1] *= 2;
            } else if (option.equals("#")) {
                score *= -1;
            }

            scores[round++] = score;
        }

        return scores[0] + scores[1] + scores[2];
    }

    // 간단 테스트
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));   // 37
        System.out.println(solution("1D2S#10S"));  // 9
        System.out.println(solution("1D2S0T"));    // 3
        System.out.println(solution("10S10S10S")); // 30
        System.out.println(solution("10S*2D#3T")); // 확인용
    }
}
