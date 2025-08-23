class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        String str = "";
        for(int i=0;i<length;i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                str+= Character.toLowerCase(s.charAt(i));
            }
        }
        
        int start = 0;
        int end = str.length() -1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}