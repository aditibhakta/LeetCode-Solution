
import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int curr = queue.poll();

                if (curr == n * n) {
                    return moves;
                }

                for (int next = curr + 1;
                     next <= Math.min(curr + 6, n * n);
                     next++) {

                    int[] pos = getPosition(next, n);

                    int row = pos[0];
                    int col = pos[1];

                    int destination = next;

                    if (board[row][col] != -1) {
                        destination = board[row][col];
                    }

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getPosition(int square, int n) {

        int rowFromBottom = (square - 1) / n;

        int row = n - 1 - rowFromBottom;

        int col = (square - 1) % n;

        if (rowFromBottom % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}
