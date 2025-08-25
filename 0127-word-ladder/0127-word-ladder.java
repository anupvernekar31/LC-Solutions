class Node{
    String word;
    int steps;
    Node(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q = new LinkedList<>();

        HashSet<String> hs = new HashSet<>();

        int n = wordList.size(); 

        for(int i=0;i<n;i++){
            hs.add(wordList.get(i));
        }

        hs.remove(beginWord);
        q.add(new Node(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();

            if(word.equals(endWord)){
                return steps;
            }

            for(int i=0;i<word.length();i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String wordString = new String(wordArray);

                    if(hs.contains(wordString)){
                        hs.remove(wordString);
                        q.add(new Node(wordString, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}