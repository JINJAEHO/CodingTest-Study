package baeckjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Problem_16947 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean[] isCycle;
    static int[] distance;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        isCycle = new boolean[N];
        for(int i=0; i<N; i++){
            if(!isCycle[i]){
                visited = new boolean[N];
                dfs(i, i, 0);
            }
        }
        distance = new int[N];
        for(int i=0; i<N; i++) {
            queue = new LinkedList<>();
            if(!isCycle[i]){
                visited = new boolean[N];
                queue.add(new Point(i, 0));
                visited[i] = true;

                while(!queue.isEmpty()){
                    Point po = queue.poll();
                    if(isCycle[po.x]) {
                        distance[i] = po.y;
                        break;
                    }
                    for(int j=0; j<graph[po.x].size(); j++){
                        int next = graph[po.x].get(j);
                        if(!visited[next]){
                            visited[next] = true;
                            queue.add(new Point(next, po.y+1));
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++) System.out.print(distance[i] + " ");
    }

    private static boolean dfs(int start, int i, int cnt){
        for(int next : graph[i]){
            if(next == start){
                if(cnt > 1) return isCycle[i] = true;
                else continue;
            }
            if(isCycle[next] || isCycle[i] || visited[next]){
                continue;
            }
            visited[next] = true;
            isCycle[i] = dfs(start, next, cnt+1);
        }
        return isCycle[i];
    }
}