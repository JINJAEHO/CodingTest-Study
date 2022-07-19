package programers;

public class Lessons_43105 {

	public static void main(String[] args) {
		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(triangle));
	}
	
	public static int solution(int[][] triangle) {
		int[][] tmp = new int[triangle.length][];
		tmp[0] = triangle[0];
		for(int i=1; i<triangle.length; i++) {
			tmp[i] = new int[triangle[i].length];
			for(int j=0; j<triangle[i].length; j++) {
				if(j==0) {
					tmp[i][0] = triangle[i][0] + tmp[i-1][0];
				}else if(j==triangle[i].length-1) {
					tmp[i][j] = triangle[i][j] + tmp[i-1][tmp[i-1].length-1];
				}else {
					tmp[i][j] = triangle[i][j] + Math.max(tmp[i-1][j-1], tmp[i-1][j]);
				}
			}
		}
		int max = -1;
		for(int i=0; i<tmp[tmp.length-1].length; i++) {
			if(tmp[tmp.length-1][i] > max) {
				max = tmp[tmp.length-1][i];
			}
		}
		return max;
	}

}
