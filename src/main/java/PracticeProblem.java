import java.util.*;

public class PracticeProblem {
    
    // Find minimum number of moves from S to F, return -1 if impossible
    // F can only be reached if there's a clear straight path (horizontal or vertical) from some reachable cell to F
    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        // Find start and finish positions
        int startRow = -1, startCol = -1;
        int finishRow = -1, finishCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
                if (maze[i][j].equals("F")) {
                    finishRow = i;
                    finishCol = j;
                }
            }
        }
        
        // Check if F is at a boundary
        boolean atBoundary = (finishRow == 0 || finishRow == rows - 1 || 
                              finishCol == 0 || finishCol == cols - 1);
        if (!atBoundary) {
            return -1;
        }
        
        // BFS treating F as impassable
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[rows][cols];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && distance[newRow][newCol] == -1
                    && !maze[newRow][newCol].equals("*")
                    && !maze[newRow][newCol].equals("F")) {
                    distance[newRow][newCol] = distance[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // Check if F can be reached from any reachable cell with a clear path
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (distance[i][j] == -1) continue; // Cell not reachable
                
                // Check if there's a clear straight path from (i,j) to F
                // Horizontal path
                if (i == finishRow) {
                    boolean clear = true;
                    int start = Math.min(j, finishCol);
                    int end = Math.max(j, finishCol);
                    for (int k = start + 1; k < end; k++) {
                        if (maze[i][k].equals("*")) {
                            clear = false;
                            break;
                        }
                    }
                    if (clear) {
                        minDist = Math.min(minDist, distance[i][j] + Math.abs(finishCol - j));
                    }
                }
                
                // Vertical path
                if (j == finishCol) {
                    boolean clear = true;
                    int start = Math.min(i, finishRow);
                    int end = Math.max(i, finishRow);
                    for (int k = start + 1; k < end; k++) {
                        if (maze[k][j].equals("*")) {
                            clear = false;
                            break;
                        }
                    }
                    if (clear) {
                        minDist = Math.min(minDist, distance[i][j] + Math.abs(finishRow - i));
                    }
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    // Count number of shortest paths from S to F
    public static int noOfPaths(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        // Find start and finish positions
        int startRow = -1, startCol = -1;
        int finishRow = -1, finishCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
                if (maze[i][j].equals("F")) {
                    finishRow = i;
                    finishCol = j;
                }
            }
        }
        
        // BFS to find shortest distance to all cells
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[rows][cols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && !maze[newRow][newCol].equals("*")
                    && distance[newRow][newCol] > distance[row][col] + 1) {
                    distance[newRow][newCol] = distance[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // If finish is unreachable
        if (distance[finishRow][finishCol] == Integer.MAX_VALUE) {
            return 0;
        }
        
        // Count paths using dynamic programming
        int[][] pathCount = new int[rows][cols];
        pathCount[startRow][startCol] = 1;
        
        // Process cells in order of increasing distance
        for (int dist = 0; dist <= distance[finishRow][finishCol]; dist++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (distance[i][j] == dist && pathCount[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int newRow = i + dr[k];
                            int newCol = j + dc[k];
                            
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                                && distance[newRow][newCol] == dist + 1) {
                                pathCount[newRow][newCol] += pathCount[i][j];
                            }
                        }
                    }
                }
            }
        }
        
        return pathCount[finishRow][finishCol];
    }
}