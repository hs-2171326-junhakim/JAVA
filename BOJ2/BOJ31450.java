import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ #31450 Everyone is a winner
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(Integer.parseInt(st.nextToken()) % Integer.parseInt(st.nextToken()) == 0 ? "Yes" : "No");
	}
}