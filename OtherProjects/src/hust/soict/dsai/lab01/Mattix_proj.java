package hust.soict.dsai.lab01;

import java.util.Scanner;
public class Mattix_proj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // nhập số hàng và số cột của 2 ma trận A và B
        System.out.print("Enter matrix rows: ");
        int m = sc.nextInt(); // số hàng
        System.out.print("Enter matrix columns: ");
        int n = sc.nextInt(); // số cột
        // tạo 2 mảng 2 chiều A và B để lưu giá trị của 2 ma trận
        int[][] A = new int[m][n];
        int[][] B = new int[m][n];


        System.out.println("Enter matrix A:");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B:");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                B[i][j] = sc.nextInt();
            }
        }

        // tạo mảng 2 chiều C để lưu kết quả tính tổng 2 ma trận A và B
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // in ma trận C
        System.out.println("Matrix C: ");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}