class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentIndex = 0;
        int cookieIndex = 0;
        while(contentIndex < g.length && cookieIndex < s.length){
            if(s[cookieIndex] >= g[contentIndex]){
                contentIndex++;
            }
            cookieIndex++;
        }
        return contentIndex;
    }
}