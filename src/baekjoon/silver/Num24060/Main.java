package baekjoon.silver.Num24060;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count, K, answer;
    static int[] temp;

    static void merge_sort(int[] A, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(A, low, mid);
            merge_sort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    static void merge(int A[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = A[i++];
        }

        while (j <= high) {
            temp[t++] = A[j++];
        }

        t = 0;
        i = low;

        while (i <= high) {
            count++;
            if (count == K) {
                answer = temp[t];
                break;
            }
            A[i++] = temp[t++];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];
        temp = new int[size];
        answer = -1;
        count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);
        System.out.print(answer);

        br.close();
    }
}