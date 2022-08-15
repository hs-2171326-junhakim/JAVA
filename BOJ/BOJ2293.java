import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ #2293 ���� 1
public class Main {
	static int[] dp, coin;

	static int solution(int n, int k) { // ���� ��� X
		for(int i = coin[0] ; i <= k ; i += coin[0]) dp[i] = 1;
		for(int i = 1 ; i < n ; i ++) {
			if(k > coin[i]) dp[coin[i]] ++;
			for(int j = coin[i] ; j <= k ; j ++) {
				dp[j] = dp[j - coin[i]] + dp[j];
			}
		}
		return dp[k];
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // ������ ����
		int k = Integer.parseInt(st.nextToken()); // ��
		dp = new int[k + 1];
		coin = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(T.solution(n, k));
	}
}
