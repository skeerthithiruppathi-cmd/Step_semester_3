
public class BusiestBusRow {
    static void busiestRow(int[][] grid) {
        int max = -1, row = 0;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            if (sum > max) {
                max = sum;
                row = i;
            }
        }

        System.out.println("Row " + row + ", Total " + max);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}
