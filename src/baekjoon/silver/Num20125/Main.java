package baekjoon.silver.Num20125;

import java.io.*;

public class Main {

    static int N, heartX, heartY, leftArm, rightArm, waist, leftLeg, rightLeg;
    static char[][] map;

    static void findHeart() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == '*' && map[i - 1][j] == '*' && map[i + 1][j] == '*' && map[i][j + 1] == '*' && map[i][j - 1] == '*') {
                    heartX = i;
                    heartY = j;
                    return;
                }
            }
        }
    }

    static void calcLength() {
        int cx, cy;

        cx = heartX;
        cy = heartY - 1;
        while (isIn(cx, cy) && map[cx][cy] == '*') {
            leftArm++;
            cy--;
        }

        cy = heartY + 1;
        while (isIn(cx, cy) && map[cx][cy] == '*') {
            rightArm++;
            cy++;
        }


        cx = heartX + 1;
        cy = heartY;
        while (isIn(cx, cy) && map[cx][cy] == '*') {
            waist++;
            cx++;
        }

        int temp = cx;

        cy = heartY - 1;
        while (isIn(cx, cy) && map[cx][cy] == '*') {
            leftLeg++;
            cx++;
        }

        cx = temp;
        cy = heartY + 1;
        while (isIn(cx, cy) && map[cx][cy] == '*') {
            rightLeg++;
            cx++;
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        findHeart();
        calcLength();

        sb.append(heartX + 1).append(" ").append(heartY + 1).append("\n")
                .append(leftArm).append(" ").append(rightArm).append(" ")
                .append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);


        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}