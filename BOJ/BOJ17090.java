import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ #17090 �̷� Ż���ϱ�
public class Main {
	static int[][] dp; // 1 => Ż�� �Ұ��� 2 => Ż�� ���� 
	//static boolean[][] visited; // >> �ð��ʰ�
	static char[][] map; 
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int N, M, answer = 0;
	
	static int DFS(int x, int y) {
		dp[y][x] = 1;
		int xx = 0, yy = 0;
		
		switch (map[y][x]) {
		case 'U': {
			xx = x + dx[0];
			yy = y + dy[0];
			break;
		}
		case 'R' : {
			xx = x + dx[1];
			yy = y + dy[1];
			break;
		}
		case 'D' : {
			xx = x + dx[2];
			yy = y + dy[2];
			break;
			
		}
		case 'L' : {
			xx = x + dx[3];
			yy = y + dy[3];
			break;
		}
		}
		if(xx >= 0 && yy >= 0 && xx < M && yy < N) { // �������� �̵��� �����ϸ�
			if(dp[yy][xx] != 0) { // �̹� Ž���� ĭ�̸�
				if(dp[yy][xx] == 2) { 
					answer ++;
					return dp[y][x] = 2;
				}
				else return dp[y][x] = 1; // ����Ŭ�� �߻��� ��쵵 ����
				
			}
			int num = DFS(xx, yy);
			if(num == 2) {
				answer ++;
				return dp[y][x] = 2;
			}
			else return dp[y][x] = 1;
		}
		else { 
			answer ++;
			return dp[y][x] = 2;// Ż���� �����ϸ�
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dp = new int[N][M];
		//visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i ++) {
			String input = br.readLine();
			for(int k = 0 ; k < M ; k ++) {
				map[i][k] = input.charAt(k);
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int k = 0 ; k < M ; k ++) {
				if(dp[i][k] == 0) { 
					DFS(k, i);
					//visited = new boolean[N][M]; // �湮 �迭 �ʱ�ȭ >> �ð��ʰ�		
				}
			}
		}
		System.out.println(answer);
	}
}
