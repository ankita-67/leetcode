import java.util.Deque;
import java.util.LinkedList;

public class rottenOranges {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot: " + ans);
    }

    private static int rotOranges(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        int freshoranges = 0, time = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if (arr[i][j] == 1)
                    freshoranges++;
            }
        }
        int direction[] = {1, 0, -1, 0, 1};
        while (!queue.isEmpty() && freshoranges > 0) {
            time++;
            for (int i = queue.size(); i > 0; i--) {
                int position[] = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = position[0] + direction[j];
                    int y = position[1] + direction[j + 1];
                    if (x >= 0 && x < row && y >= 0 && y < col && arr[x][y] == 1) {
                        arr[x][y] = 2;
                        freshoranges--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return (freshoranges>0?-1:time);

    }
}