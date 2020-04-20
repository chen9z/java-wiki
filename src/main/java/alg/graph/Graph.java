package alg.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表实现无向图
 * Created by chen on 2020/3/24.
 */
public class Graph {

    private int v;
    private LinkedList<Integer> [] link;

    public Graph(int v) {
        this.v = v;
        link = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            link[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        link[s].add(t);
        link[t].add(s);
    }


    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < link[w].size(); ++i) {
                int q = link[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
