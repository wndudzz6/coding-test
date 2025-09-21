package kakao.파싱;

public class 문자열압축 {
    public static int solution(String s) {
        int n = s.length();
        if (n == 1) return 1; // 한 글자는 그대로

        int answer = n; // 최댓값으로 시작
        for (int unit = 1; unit <= n / 2; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;

            // unit 크기씩 건너뛰며 비교
            for (int i = unit; i < n; i += unit) {
                int end = Math.min(i + unit, n); //i+unit이 n넘는거 방지
                String cur = s.substring(i, end);

                if (prev.equals(cur)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            // 마지막 덩어리 처리
            if (count > 1) sb.append(count);
            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

    private static int digits(int x) {
        // 1~9:1자리, 10~99:2자리 ...
        int d = 0;
        while (x > 0) { d++; x /= 10; }
        return d;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); //7
        System.out.println(solution("ababcdcdababcdcd")); //9
        System.out.println(solution("abcabcdede")); //8
        System.out.println(solution("abcabcabcabcdededededede")); //14
        System.out.println(solution("xababcdcdababcdcd")); //17
    }
}
