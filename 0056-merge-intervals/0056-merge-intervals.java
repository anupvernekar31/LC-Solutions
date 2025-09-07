class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        List<int[]> ans=new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int[] current=intervals[0];
        ans.add(current);

        for(int i=1;i<n;i++){

            int[] interval=intervals[i];

            if(interval[0]<=current[1]){
                current[1]=Math.max(current[1],interval[1]);
            }else{
                current=interval;
                ans.add(current);
            }

        }
        return ans.toArray(new int[ans.size()][]);
    }
}