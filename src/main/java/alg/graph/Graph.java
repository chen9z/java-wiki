package alg.graph;

import java.util.LinkedList;

/**
 * 邻接表实现无向图
 * Created by chen on 2020/3/24.
 */
public class Graph {

    private int count;
    private LinkedList<Integer> [] link;

    public Graph(int count) {
        this.count=count;
        link = new LinkedList[count];
        for (int i = 0; i <count ; i++) {
            link[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        link[s].add(t);
        link[t].add(s);
    }
}
