public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if((m == 1) || (n == 1)) return 1;
        int[][] maps = new int[m][n];
        if(obstacleGrid[0][0] == 0)
            maps[0][0] = 1;
        else
            maps[0][0] = 0;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 1 || maps[i - 1][0] == 0)
                maps[i][0] = 0;
            else
                maps[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 1 || maps[0][i - 1] == 0)
                maps[0][i] = 0;
            else
                maps[0][i] = 1;
        }
        for(int i = 1; i < m; i ++)
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0)
                    maps[i][j] = maps[i - 1][j] + maps[i][j - 1];
                else
                    maps[i][j] = 0;

            }
        return maps[m - 1][n - 1];
            
    }
}
