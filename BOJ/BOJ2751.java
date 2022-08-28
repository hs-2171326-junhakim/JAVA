import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ #2751 �� �����ϱ� 2
public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i ++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
		}
		Arrays.sort(arr);
		for(int i = 0 ; i < N ; i ++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
	}
}
