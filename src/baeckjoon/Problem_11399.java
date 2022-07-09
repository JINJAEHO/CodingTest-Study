package baeckjoon;

import java.util.Scanner;

public class Problem_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(a[i] > a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				sum += a[j];
			}
		}
		System.out.print(sum);
	}

}
