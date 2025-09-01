class Pair {
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // ==================================================================================
    // THIS SOLUTIONS WORKS FINE BUT IN ORDER TO RETURN SORTED ARRAY IT TAKES O(N LOG N)
    // ==================================================================================

    // public List<Integer> findClosestElements(int[] arr, int k, int x) {

    //     PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> {
    //         if (a.first != b.first) return Integer.compare(b.first, a.first); // larger dist first
    //         return Integer.compare(b.second, a.second); // for ties, larger value first (so it gets removed)
    //     });

    //     for(int i=0;i<arr.length;i++){
    //         pq.offer(new Pair(Math.abs(arr[i] - x), arr[i]));

    //         if(pq.size() > k){
    //             pq.poll();
    //         }
    //     }

    //     List<Integer> ans = new ArrayList<>(k);
    //     while (!pq.isEmpty()) ans.add(pq.poll().second);
    //     Collections.sort(ans); // problem requires ascending order
    //     return ans;
        
    // }

    // ==================================================================================
    // GIVEN ARRAY IS SORTED WE CAN USE LOWER BOUND TC: O(LOG N + K)
    // ==================================================================================


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        // 1) lowerBound: first index i where arr[i] >= x
        int right = lowerBound(arr, x);
        int left = right - 1;

        // We'll expand the window [left+1, right-1] to size k
        int picks = k;

        while (picks-- > 0) {
            // If left is exhausted, must take from right
            if (left < 0) {
                right++;
            }
            // If right is exhausted, must take from left
            else if (right >= n) {
                left--;
                continue;
            }

            else {
                // Compare distances
                int dl = Math.abs(arr[left] - x);
                int dr = Math.abs(arr[right] - x);

                if (dl <= dr) {
                    // Left is closer (or tie -> prefer smaller value on left)
                    left--;
                } else {
                    // Right is closer
                    right++;
                }
            }   
        }

        // Elements are now in the inclusive range (left, right)
        List<Integer> res = new ArrayList<>(k);
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public int lowerBound(int []arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}