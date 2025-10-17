package kakao.시뮬레이션;

import java.util.*;

public class 기둥과보설치{
    static class Solution {
        int n;
        boolean[][][] state; // [x][y][a] → a=0 기둥, a=1 보

        public int[][] solution(int n, int[][] build_frame) {
            this.n = n;
            state = new boolean[n+3][n+3][2]; // 여유 padding

            for (int[] frame : build_frame) {
                int x = frame[0];
                int y = frame[1];
                int a = frame[2]; // 0=기둥, 1=보
                int b = frame[3]; // 0=삭제, 1=설치

                if (b == 1) { // 설치
                    state[x][y][a] = true;
                    if (!isValid()) {
                        state[x][y][a] = false; // 롤백
                    }
                } else { // 삭제
                    state[x][y][a] = false;
                    if (!isValid()) {
                        state[x][y][a] = true; // 롤백
                    }
                }
            }

            // 결과 수집
            List<int[]> result = new ArrayList<>();
            for (int x = 0; x <= n; x++) {
                for (int y = 0; y <= n; y++) {
                    for (int a = 0; a < 2; a++) {
                        if (state[x][y][a]) {
                            result.add(new int[]{x, y, a});
                        }
                    }
                }
            }

            // 정렬 조건: x → y → a
            result.sort((o1, o2) -> {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[2] - o2[2];
            });

            return result.toArray(new int[result.size()][]);
        }

        // 전체 구조물이 유효한지 체크
        private boolean isValid() {
            for (int x = 0; x <= n; x++) {
                for (int y = 0; y <= n; y++) {
                    if (state[x][y][0]) { // 기둥
                        if (!(y == 0 || state[x][y-1][0] || state[x][y][1] || (x > 0 && state[x-1][y][1]))) {
                            return false;
                        }
                    }
                    if (state[x][y][1]) { // 보
                        if (!(state[x][y-1][0] || state[x+1][y-1][0] || (x > 0 && state[x-1][y][1] && state[x+1][y][1]))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5;
        int[][] build_frame = {
                {1,0,0,1},
                {1,1,1,1},
                {2,1,0,1},
                {2,2,1,1},
                {5,0,0,1},
                {5,1,0,1},
                {4,2,1,1},
                {3,2,1,1}
        };

        int[][] result = sol.solution(n, build_frame);

        System.out.println("결과:");
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
