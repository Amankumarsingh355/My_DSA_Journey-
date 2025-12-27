class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            image[i] = flipHorizontal(image[i]);
            image[i] = invertRow(image[i]);
        }
        return image;
    }
    public int[] flipHorizontal(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
        return row; 
    }
    public int[] invertRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = (row[i] == 0) ? 1 : 0;  
        }
        return row;
    }
}