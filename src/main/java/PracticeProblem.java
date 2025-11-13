import java.util.LinkedList;
import java.util.Queue;

public class PracticeProblem {

    // 1️⃣ Minimum number of moves (BFS)
    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Locate the start position
        int startRow = rows - 1;
        int startCol = 0;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        // {row, col, moves}
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], moves = curr[2];

            if (maze[r][c].equals("F")) {
                return moves; // found finish
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        !maze[nr][nc].equals("*") && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, moves + 1});
                }
            }
        }

        return -1; // finish not reachable
    }

    // 2️⃣ Count all paths (DFS with backtracking)
    public static int noOfPaths(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int startRow = rows - 1;
        int startCol = 0;

        return dfsPaths(maze, startRow, startCol, visited);
    }

    private static int dfsPaths(String[][] maze, int r, int c, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Out of bounds or wall or already visited
        if (r < 0 || r >= rows || c < 0 || c >= cols || maze[r][c].equals("*") || visited[r][c])
            return 0;

        // Found finish
        if (maze[r][c].equals("F"))
            return 1;

        visited[r][c] = true;

        // Move in all four directions
        int paths = dfsPaths(maze, r - 1, c, visited)   // up
                  + dfsPaths(maze, r + 1, c, visited)   // down
                  + dfsPaths(maze, r, c - 1, visited)   // left
                  + dfsPaths(maze, r, c + 1, visited);  // right

        visited[r][c] = false; // backtrack

        return paths;
    }

    // --- Example test ---
    public static void main(String[] args) {
        String[][] maze = {
            {"", "", "", "F"},
            {"", "*", "", ""},
            {"", "", "", ""},
            {"S", "", "*", ""}
        };

        System.out.println("Minimum moves: " + searchMazeMoves(maze)); // e.g., 6
        System.out.println("Number of paths: " + noOfPaths(maze));     // e.g., 4
    }
}
