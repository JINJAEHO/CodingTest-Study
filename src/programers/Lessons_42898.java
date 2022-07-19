package programers;

public class Lessons_42898 {
	public static void main(String[] args) {
		int[][] puddls = {{2,2}, {3,1}};
		System.out.println(solution(4, 3, puddls));
	}
	
	public static int solution(int m, int n, int[][] puddls) {
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		for(int i=0; i<puddls.length; i++) {
			dp[puddls[i][1]-1][puddls[i][0]-1] = -1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dp[i][j] != -1) {
					int a=0,b=0;
					if(i-1 >= 0 && dp[i-1][j] != -1){
						a = dp[i-1][j];
					}
					if(j-1 >= 0 && dp[i][j-1] != -1) {
						b = dp[i][j-1];
					}
					dp[i][j] = (a + b) % 1000000007;
				}
				if(i==0 && j==0) dp[i][j] = 1;
			}
		}
		return (dp[n-1][m-1] % 1000000007);
	}
}
