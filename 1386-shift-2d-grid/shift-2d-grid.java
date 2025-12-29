class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rowCount = grid.length;                         
        int colCount = grid[0].length;                      
        int gridCount = rowCount * colCount;              
        k = k % gridCount;                                  
        int kCol = (gridCount - k) % colCount;              
        int kRow = ((gridCount - k) % gridCount) / colCount;
        int[] innRow = grid[kRow];                         
        int[][] result = new int[rowCount][colCount];      
        for (int r = 0; r < rowCount; r++) {                
            int[] outRow = result[r];                      
            for (int c = 0; c < colCount; c++) {            
                outRow[c] = innRow[kCol];                   
                if (++kCol >= colCount) {                   
                    kCol = 0;                               
                    if (++kRow >= rowCount)                 
                        kRow = 0;                          
                    innRow = grid[kRow];                    
                }
            }
        }
        return (List)Arrays.asList(result);                 
    }
}