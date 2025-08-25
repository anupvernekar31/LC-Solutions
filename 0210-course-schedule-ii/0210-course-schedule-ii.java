class Solution {

    // Ar
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // prerequisites[i] = [course, prereq]
        for (int[] p : prerequisites) {
            int course = p[0], prereq = p[1];
            g.get(prereq).add(course);   // prereq -> course
            indegree[course]++;          // incoming edge to course
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g.get(u)) {
                if (--indegree[v] == 0) q.add(v);
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}