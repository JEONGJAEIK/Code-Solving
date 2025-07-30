import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 골드 3 파티
public class Main {

    static int studentTotal, roadTotal, targetCity;
    static int n;

    static class Edge {
        int next;
        int time;

        public Edge(int next, int time) {
            this.next = next;
            this.time = time;
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        studentTotal = Integer.parseInt(st.nextToken());
        roadTotal = Integer.parseInt(st.nextToken());
        targetCity = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();


        for (int i = 0; i < 1001; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < roadTotal; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(startCity).add(new Edge(endCity, time));
            reverseGraph.get(endCity).add(new Edge(startCity, time));
        }

        n = graph.size();
        
        int[] go = dijkstra(graph, targetCity);
        int[] back = dijkstra(reverseGraph, targetCity);

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (go[i] == Integer.MAX_VALUE || back[i] == Integer.MAX_VALUE) {
                continue;
            }
            max = Math.max(max, go[i] + back[i]);
        }
        System.out.println(max);
    }

    static int[] dijkstra(List<List<Edge>> graph, int start) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.index;
            int currentTime = current.time;

            visited[currentIndex] = true;

            for (Edge edge : graph.get(currentIndex)) {
                int neighbor = edge.next;
                int time = edge.time;

                if (!visited[neighbor]) {
                    int newTime = currentTime + time;

                    if (newTime < distance[neighbor]) {
                        distance[neighbor] = newTime;
                        pq.offer(new Node(neighbor, newTime));
                    }
                }
            }
        }
        return distance;

    }
}