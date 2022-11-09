import java.util.ArrayDeque;
import java.util.Queue;

public class task_01 {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    private static boolean isValid(int[][] mat, int[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length) && mat[row][col] == 1 && visited[row][col] == 0;
    }

    public static int findShortestPath(int[][] mat, int i, int j, int x, int y) {
        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
            return -1;
        }

        int M = mat.length;
        int N = mat[0].length;
        int[][] visited = new int[M][N];
        Queue<Node> q = new ArrayDeque<>();

        visited[i][j] = -1;
        q.add(new Node(i, j, 1));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                String wayOut = formWayOut(visited, x, y, min_dist);
                printWayOut(wayOut, mat, M, N);
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = dist;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }

    private static String formWayOut(int[][] visited, int x, int y, int min_dist) {
        StringBuilder wayOut = new StringBuilder("");
        wayOut.append("0, 0 - ");
        wayOut.append(String.format("%d, %d - ", x, y));
        while (min_dist-- != 0) {
            for (int k = 0; k < 4; k++) {
                if (x == 0 && k == 0) continue; 
                if (y == 0 && k == 1) continue; 
                if (visited[x + row[k]][y + col[k]] == min_dist) {
                    x += row[k];
                    y += col[k];
                    wayOut.append(String.format("%d, %d - ", x, y));
                    break;
                }
            }
        }
        return wayOut.toString();
    }

    private static void printWayOut(String wayOut, int[][] mat, int M, int N) {
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                if (wayOut.contains(String.format("%d, %d", a, b))) {
                    System.out.print(ANSI_YELLOW + mat[a][b] + "\t" + ANSI_CYAN);
                } else {
                    System.out.print(mat[a][b] + "\t");
                }
            }
            System.out.println();
        }
    }
}