class Solution {
    
    private boolean bfs(int node, int[] color, int[][] graph)
    {
        // Queue for bfs
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(node);
        color[node] = 0;

        while(!q.isEmpty())
        {
            int cN = q.poll();

            // get adjacent nodes
            for(int it : graph[cN])
            {
                // if not colored, color & add into queue
                if(color[it] == -1)
                {
                    color[it] = 1 - color[cN];
                    q.add(it);
                }
                // if already colored, compare
                if(color[it] == color[cN]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) 
    {
        // No.of Vertices/Nodes
        int V = graph.length;

        // Create Color array & mark everyone as -1
        int[] color = new int[V];

        for(int i = 0; i < V; i++) color[i] = -1; // Uncoloured initially 

        // Traverse the nodes
        for(int i = 0; i < V; i++)
        {
            if(color[i] == -1) // Uncolored
            {
                if(bfs(i, color, graph) == false)
                {
                    return false; // Not-a-bipartite
                }
            }
        }
        return true; // Bipartite
    }
}