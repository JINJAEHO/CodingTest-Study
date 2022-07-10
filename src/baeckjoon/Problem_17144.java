package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] condition = br.readLine().split("\\s+");
		int r = Integer.parseInt(condition[0]);
		int c = Integer.parseInt(condition[1]);
		int t = Integer.parseInt(condition[2]);
		
		int[][] arr = new int[r][c];
		int[][] outLine = new int[r+2][c+2];
		int a = 0, b = 0;
		for(int i=0; i<r; i++) {
			String[] tmp = br.readLine().split("\\s+");
			int k=0;
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(tmp[k]);
				k++;
				if(arr[i][j]==-1) {
					a = i-1;
					b = i;
				}
			}
		}
		for(int i=0; i<r+2; i++) {
			for(int j=0; j<c+2; j++) {
				if(i==0 || i==r+1 || j==0 || j==c+1) outLine[i][j] = -1;
				else outLine[i][j] = arr[i-1][j-1];
			}
		}
		for(int k=t; k>0; k--) {
			int[][] origin = outLine;
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(origin[i+1][j+1] != 0 || origin[i+1][j+1] != -1) {
						if(origin[i][j+1] != -1) {
							arr[i-1][j] += origin[i+1][j+1]/5;
							arr[i][j] -= origin[i+1][j+1]/5;
						}
						if(origin[i+1][j+2] != -1) {
							arr[i][j+1] += origin[i+1][j+1]/5;
							arr[i][j] -= origin[i+1][j+1]/5;
						}
						if(origin[i+2][j+1] != -1) {
							arr[i+1][j] += origin[i+1][j+1]/5;
							arr[i][j] -= origin[i+1][j+1]/5;
						}
						if(origin[i+1][j] != -1) {
							arr[i][j-1] += origin[i+1][j+1]/5;
							arr[i][j] -= origin[i+1][j+1]/5;
						}
					}
				}
			}
			int[][] copy = arr;
			for(int i=a-1; i>0; i--) {
				arr[i][0] = copy[i-1][0];
			}
			for(int i=b+1; i<r-1; i++) {
				arr[i][0] = copy[i+1][0];
			}
			for(int i=0; i<c-1; i++) {
				arr[0][i] = copy[0][i+1];
				arr[r-1][i] = copy[r-1][i+1];
			}
			for(int i=0; i<a; i++) {
				arr[i][c-1] = copy[i+1][c-1];
			}
			for(int i=r-1; i>b; i--) {
				arr[i][c-1] = copy[i-1][c-1];
			}
			for(int j=c-1; j>1; j--) {
				arr[a][j] = copy[a][j-1];
				arr[b][j] = copy[b][j-1];
			}
			arr[a][1] = 0;
			arr[b][1] = 0;

			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					origin[i+1][j+1] = arr[i][j];
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j]!=-1 && arr[i][j]!=0) ans += arr[i][j];
			}
		}
		System.out.print(ans);
	}
}
