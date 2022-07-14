package baeckjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_1014
{
    // 교실 세로 길이 (y)
    private static int N;
    
    // 교실 가로 길이 (x)
    private static int M;
    
    // 자리 번호
    private static int[][] room;
    
    // 컨닝 가능한 자리
    private static boolean[][] nodes;
    
    // 방문 횟수
    private static int visitCount;
    
    // 버텍스별 방문 횟수
    private static int[] visit;
    
    // 버텍스 매칭 여부
    private static int[] matched;
    
    /**
     * 메인 함수
     *
     * @param args: [String[]] 매개변수
     *
     * @throws IOException 데이터 입출력 예외
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 현재 자리에서 컨닝이 가능한 자리의 위치 상대좌표
        int[][] scopes = { { -1, 1 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        
        // 케이스 수
        int C = Integer.parseInt(reader.readLine());
        
        while (C-- > 0)
        {
            String[] temp = reader.readLine().split(" ");
            
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            
            // 자리의 파손 여부
            boolean[][] canSit = new boolean[N][M];
            
            // 자리의 번호
            int numbering = 1;
            
            // 파손된 자리의 총 갯수
            int broken = 0;
            
            room = new int[N][M];
            nodes = new boolean[N * M][N * M];
            
            visitCount = 1;
            
            for (int n = 0; n < N; n++)
            {
                temp = reader.readLine().split("");
                
                for (int m = 0; m < M; m++)
                {
                    // 자리 번호 기록
                    room[n][m] = numbering++;
                    
                    // 앉을 수 있는 경우
                    if (temp[m].equals("."))
                    {
                        canSit[n][m] = true;
                    }
                    
                    // 파손된 경우
                    else
                    {
                        canSit[n][m] = false;
                        
                        // 파손 갯수 1 추가
                        broken++;
                    }
                }
            }
            
            for (int n = 0; n < N; n++)
            {
                // 홀수 열만 대상으로 동작함
                for (int m = 0; m < M; m += 2)
                {
                    // 앉을 수 있는 좌석일 경우
                    if (canSit[n][m])
                    {
                        for (int[] scope : scopes)
                        {
                            // 컨닝 가능성 있는 자리의 상대좌표
                            int no = n + scope[1];
                            int mo = m + scope[0];
                            
                            // 상대좌표가 교실을 벗어나지 않으면서, 앉을 수 있을 경우
                            if (no > -1 && mo > -1 && no < N && mo < M && canSit[no][mo])
                            {
                                // 노드 연결 표시
                                nodes[room[n][m] - 1][room[no][mo] - 1] = true;
                            }
                        }
                    }
                }
            }
            
            int result = bipartite();
            
            writer.write(Integer.toString(N * M - broken - result));
            writer.newLine();
            writer.flush();
        }
        
        writer.close();
        reader.close();
    }
    
    /**
     * 이분 매칭 갯수 반환 함수
     *
     * @return [int] 이분 매칭 갯수
     */
    private static int bipartite()
    {
        // 매칭 갯수
        int size = 0;
        
        visit = new int[N * M];
        
        matched = new int[N * M];
        
        Arrays.fill(matched, -1);
        
        for (int n = 0; n < N; n++)
        {
            for (int m = 0; m < M; m += 2)
            {
                visitCount++;
                
                size += dfs(room[n][m] - 1);
            }
        }
        
        return size;
    }
    
    /**
     * DFS 알고리즘 결과 반환 함수
     *
     * @param num: [int] 시작점
     *
     * @return [int] 매칭 갯수
     */
    private static int dfs(int num)
    {
        // 같은 버텍스가 아닐 경우
        if (visit[num] != visitCount)
        {
            visit[num] = visitCount;
            
            for (int i = 0; i < N * M; i++)
            {
                // num과 i 버텍스 사이에 노드가 존재할 경우
                if (nodes[num][i])
                {
                    // 아직 매칭되지 않았거나, 이미 i와 매칭된 버텍스가 다른 버텍스와 매칭할 수 있을 경우
                    if (matched[i] == -1 || dfs(matched[i]) == 1)
                    {
                        matched[i] = num;
                        
                        return 1;
                    }
                }
            }
        }
        
        return 0;
    }
}
