class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = 10000;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < list1.length; i++)
            for (int j = 0; j < list2.length; j++)
                if (list1[i].equals(list2[j])) {
                    if (i + j <= min) {
                        if (i + j < min) {
                            arr.clear();
                            min = i + j;
                        }
                        arr.add(list1[i]);
                    }
                    break;
                }
        return arr.toArray(new String[0]);
    }
}