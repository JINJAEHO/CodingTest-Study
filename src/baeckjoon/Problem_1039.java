package baeckjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1039 {
	static boolean[][] visit = new boolean[1000001][11];
	static int N, K;
	static String str;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	str = st.nextToken();
    	N = Integer.parseInt(str);
    	K = Integer.parseInt(st.nextToken());
    	
    	bfs();
    }
    
    private static void bfs() {
    	Queue<Point> queue = new LinkedList<Point>();
    	queue.add(new Point(N, 0));
    	visit[N][0] = true;
    	while(!queue.isEmpty()) {
    		if(queue.peek().y == K) {
    			break;
    		}
    		
    		Point po = queue.poll();
    		for(int i=0; i<str.length()-1; i++) {
    			for(int j=i+1; j<str.length(); j++) {
    				int next = solve(po.x, i, j);
    				if(next != -1 && !visit[next][po.y+1]) {
    					visit[next][po.y+1] = true;
    					queue.add(new Point(next, po.y+1));
    				}
    			}
    		}
    	}
    	int result = -1;
    	while(!queue.isEmpty()) {
    		Point po = queue.poll();
    		if(result < po.x) {
    			result = po.x;
    		}
    	}
    	System.out.println(result);
    }
    
    private static int solve(int x, int i, int j) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(x);
    	if(i==0 && sb.charAt(j)=='0') return -1;
    	
    	char tmp = sb.charAt(i);
    	sb.setCharAt(i, sb.charAt(j));
    	sb.setCharAt(j, tmp);
    	return Integer.parseInt(sb.toString());
    }
}