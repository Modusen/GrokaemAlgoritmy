package graphs;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private final Vertex[] vertexList;
    private final int[][] adjustmentMatrix;
    private int nVerts;
    private final Stack<Integer> theStack = new Stack<>();

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjustmentMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjustmentMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjustmentMatrix[start][end] = 1;
        adjustmentMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.print(vertexList[vertex].getLabel());
    }

    int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjustmentMatrix[v][j] == 1 && !vertexList[j].isWasVisited()) {
                return j;
            }
        }
        return -1;
    }

    public void deepFirstSearch() {
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].setWasVisited(true);
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setWasVisited(false);
        }
    }
}