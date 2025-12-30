class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int sum = 0;
        int n = salary.length;
        for(int i=0;i<n;i++){
            min = Math.min(salary[i],min);
            max = Math.max(salary[i],max);
            sum+=salary[i];
        }
        sum = sum - min - max;
        return (double)(sum)/(double)(n-2);
    }
}