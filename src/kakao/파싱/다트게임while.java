package kakao.파싱;

import java.util.*;

//문제 핵심 1. 불규칙한 문자열 정확하게 파싱 / 2. 각 라운드의 상태 관리 / 옵션 따라 수정가능한 구조
//직전 라운드만 쓰니까 상태배열 대신 stack을 써도 된다
public class 다트게임while {
    public static int solution(String dartResult) {
        int[] scores = new int[3];
        int round = 0;
        int i = 0, n = dartResult.length();

        while (i < n && round < 3) {
            // 1) 점수(0~10) 읽기: 연속된 숫자를 모두 모아 정수로 **템플릿 : 숫자파싱
            int score = 0;
            while (i < n && Character.isDigit(dartResult.charAt(i))) {
                score = score * 10 + (dartResult.charAt(i) - '0');
                i++;
            }

            // 2) 보너스(S/D/T) 적용
            char bonus = dartResult.charAt(i); // 반드시 존재
            if (bonus == 'D')      score = score * score;          // 제곱
            else if (bonus == 'T') score = score * score * score;  // 세제곱
            // 'S'는 그대로

            i++; //보너스 봤으니 옵션으로 넘어가자

            // 3) 옵션(* 또는 #) 처리 (있을 수도, 없을 수도)
            if (i < n) { //예외 체크를 꼭 해야 함 없으면 오류나니까
                char opt = dartResult.charAt(i);
                if (opt == '*') {
                    score *= 2;                     // 이번 라운드 2배
                    if (round > 0) scores[round-1] *= 2; // 이전 라운드도 2배
                    i++;
                } else if (opt == '#') {
                    score *= -1; // 이번 라운드 마이너스
                    i++;
                }
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
        System.out.println(solution("10S*2D#3T")); // 케이스 확인용
    }
}
