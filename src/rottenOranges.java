import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] delRow = {-1,0,1 ,0};
        int[] delcol = {0,1,0,-1};
        int [][]vis = new int[n][m];
        int freshCount =0;
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j] == 2)
                {
                    q.add(new int[]{i,j,0});
                    vis[i][j] =2;
                }
                else
                {
                    vis[i][j]=0;
                }
                if(arr[i][j]==1)
                    freshCount++;
            }
        }
        int tm=0, cnt =0;
        while (!q.isEmpty())
        {
            int curr[] =q.poll();
            int row =curr[0];
            int col = curr[1];
            int t = curr[2];

            tm = Math.max(tm,t);

            for(int i=0;i<4;i++)
            {
                int newRow = row + delRow[i];
                int newCol = col + delcol[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && arr[newRow][newCol] == 1 &&  vis[newRow][newCol] != 2 )
                {
                    vis[newRow][newCol] = 2;
                    q.add(new int[]{ newRow,newCol, t+1});
                    cnt++;
                }
            }

        }

return (cnt == freshCount) ? tm : -1;
    }
}
