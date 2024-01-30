package baekjoon.silver.Num01244;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // N: 스위치 개수, T: 학생수, gender: 성별[1:남자,2:여자], number: 학생이 받은 수
    static int N, T, gender, number;
    // 스위치 값 저장할 배열
    static int[] arr;

    //toggle 기능( 0일 경우 1로, 1일 경우 0으로 값 변환)
    static void helper(int idx) {
        arr[idx] = arr[idx] == 0 ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            gender = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());

            // 남자일 경우
            if (gender == 1) {
                // idx는 0부터 시작이므로 초기값 number-1 , number 배수 모두 toggle 진행 
                for (int i = number - 1; i < N; i += number) {
                    helper(i);
                }
            } else if (gender == 2) { // 여자일 경우
                // idx는 0부터 시작
                number -= 1;
                int l = number - 1;
                int r = number + 1;
                // 자신이 받은 숫자 toggle 진행
                helper(number);

                // 배열의 양 끝까지 탐색
                while (l >= 0 && r < N) {
                    // 좌,우 값이 동일하지 않을 경우 toggle 종료
                    if (arr[l] != arr[r]) {
                        break;
                    }
                    helper(l--);
                    helper(r++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");

            //20번째 스위치마다 줄바꿈 진행
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}