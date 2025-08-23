class Solution {

    static long solve(ArrayList<Integer> arr){
    int n = arr.size();
    long prev = arr.get(0);
    long prev2 =0;
    
    for(int i=1; i<n; i++){
        long pick = arr.get(i);
        if(i>1)
            pick += prev2;
        long nonPick = 0 + prev;
        
        long cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
        
    }
    return prev;
}
    public int rob(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: nums){
            arr.add(i);
        }
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        int n= nums.length;
        if(n==1)
            return arr.get(0);
    
        for(int i=0; i<n; i++){
            if(i!=0) arr1.add(arr.get(i));
            if(i!=n-1) arr2.add(arr.get(i));
        }
    
        long ans1 = solve(arr1);
        long ans2 = solve(arr2);
    
        return Math.max((int)ans1,(int)ans2);
    }
}