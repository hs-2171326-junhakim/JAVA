import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ #5719 ���� �ִ� ���
class Edge implements Comparable<Edge>{
	int node;
	int cost;
	public Edge(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}
public class Main {
	static ArrayList<Edge>[] list;
	static ArrayList<Integer>[] preNode;
	static int d[];
	static boolean ch[][]; // [����][����]
	static StringBuilder sb = new StringBuilder();
	static int S, D;
	
	static void dijkstra() { // ���ͽ�Ʈ��
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		d[S] = 0;
		pQ.offer(new Edge(S,0));
		
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			if(d[tmp.node] < tmp.cost) continue;
			for(Edge next : list[tmp.node]) {
				if(ch[tmp.node][next.node]) continue; // ������ ���ŵ��� �ʾ�����
					int nextD = d[tmp.node] + next.cost;
					if(d[next.node] > nextD) {
						preNode[next.node].clear();
						preNode[next.node].add(tmp.node);
						d[next.node] = nextD;
						pQ.offer(new Edge(next.node, nextD));
					}
					else if(d[next.node] == nextD) preNode[next.node].add(tmp.node);
			}
		}
		
	}
	static void DFS(int node) { // ��Ʈ��ŷ���� ���ŵ� ���� üũ
		if(node == S) return;
		for(int x : preNode[node]) {	
			if(!ch[x][node]) {
				ch[x][node] = true;
				DFS(x);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N,M;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken()); // ������
			D = Integer.parseInt(st.nextToken()); // ������
			
			ch = new boolean[N][N];
			list = new ArrayList[N];
			preNode = new ArrayList[N];
			d = new int[N];
			
			for(int i = 0 ; i < N ; i ++) {
				list[i] = new ArrayList<>();
				preNode[i] = new ArrayList<>();
			}
			
			Arrays.fill(d, Integer.MAX_VALUE);
			int start, end, cost; // �ܹ���
			for(int i = 0 ; i < M ; i ++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				list[start].add(new Edge(end, cost));
			}
			
			dijkstra();
			DFS(D);
			Arrays.fill(d, Integer.MAX_VALUE);
			dijkstra();
		
			if(d[D] == Integer.MAX_VALUE) sb.append("-1" + '\n');
			else sb.append(d[D]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
