class Solution {
    public void duplicateZeros(int[] arr) {
        int dup_arr[] = new int[arr.length];
        int i = 0;
        int j = 0;
        while(i != arr.length && j != arr.length) {
            if(arr[i] != 0) {
                dup_arr[j] = arr[i];
                j++;
                i++;
            } else {
                if(j == arr.length - 1) {
                    dup_arr[j] = arr[i];
                    break;
                }
                dup_arr[j] = arr[i];
                dup_arr[j + 1] = arr[i];
                j = j + 2;
                i++;
            }
        }
        for(int a = 0; a < arr.length; a++) {
            int temp = arr[a];
            arr[a] = dup_arr[a];
        }
    }
}