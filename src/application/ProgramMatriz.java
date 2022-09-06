package application;

import java.util.Scanner;

public class ProgramMatriz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matriz = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		
		int number = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matriz[i][j] == number) {
					System.out.println("Position " + i + ", " + j + ":");
					if (j - 1 != -1) 
						System.out.println("Left: " + matriz[i][j-1]);
					if (i - 1 != -1)
						System.out.println("Up: " + matriz[i-1][j]);
					if (j + 1 != m)
						System.out.println("Right: " + matriz[i][j+1]);
					if (i + 1 != n)
						System.out.println("Down: " + matriz[i+1][j]);
				}
			}
		}
		sc.close();
	}
}
