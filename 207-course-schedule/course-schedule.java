class Solution {
    ArrayList<Integer> al[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        al = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) al[i] = new ArrayList<>();
        int deg[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            al[prerequisites[i][1]].add(prerequisites[i][0]);
            deg[prerequisites[i][0]]++;
        }
        
        int cnt=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(deg[i]==0){
                 q.add(i);
                 cnt++;
            }   
        }

        while(q.size()>0){
            int rem = q.remove();
            for(int v:al[rem]){
                deg[v]--;
                if(deg[v]==0) {
                    cnt++;
                    q.add(v);
                }
            }
        }

        return cnt==numCourses;



    }
}