class Pair{
    int freq, num;
    public Pair(int freq, int num){
        this.freq = freq;
        this.num = num;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)-> {
            if(a.freq!= b.freq) return Integer.compare(a.freq, b.freq);
            return Integer.compare(a.num, b.num);
        });

        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[k];

        int n = nums.length;

        for(int i=0;i<n;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            pq.add(new Pair(value, key));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int ind = 0;
        while(pq.size() > 0){
            ans[ind++] = pq.poll().num;
        }
        return ans;
    }
}