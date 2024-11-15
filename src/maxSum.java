//Max path sum from bottom left to top left (north to east movement allowed)
public class maxSum {
    public static void main(String[] args) {

            int [][]grid = {{1, 2}, {3, 5}};
            System.out.print(MaximumPath(grid));

    }

    private static int MaximumPath(int[][] grid) {

        int n= grid.length;
        int m = grid[0].length;
        int[][] sum =  new int[n+1][m+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                sum[i][j] = Math.max(sum[i-1][j],sum[i][j-1])+grid[i-1][j-1];
            }
        }


        return sum[n][m];

    }
}
