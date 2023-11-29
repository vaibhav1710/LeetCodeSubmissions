class Solution {
    public int[] lexicographicallySmallestArray(int[] a, int limit) {
        int n = a.length;
        int [][]b = new int[n][2];

        for(int i=0;i<n;i++){
            b[i][0]=a[i];
            b[i][1] = i;
        }
        Arrays.sort(b,(p,q) -> {
            return p[0]-q[0];
        });

         DSU dsu = new DSU(n);

         for(int i=1;i<n;i++){
             if(b[i][0] - b[i-1][0] <= limit){
                 dsu.union(b[i][1],b[i-1][1]);
             }
         }

         Map<Integer, List<Integer>> hm = new HashMap<>();

         for(int i=0;i<n;i++) hm.put(i,new ArrayList<>());
         for(int i=0; i<n; i++) {
            hm.get(dsu.root(i)).add(i);
          }

          int ans[] = new int[n];
          for(int i=0;i<n;i++){
              if(dsu.root(i)!=i) continue;
              List<int[]> comp = new ArrayList<>();
              for(int j:hm.get(i)){
                  comp.add(new int[]{j,a[j]});
              }
              Collections.sort(comp,(p,q)->p[1]-q[1]);

              for(int j=0;j<comp.size();j++){
                  ans[hm.get(i).get(j)] = comp.get(j)[1];
              }
          }
       return ans;

    }
private  class DSU {
		private int[] id;
		private int[] size;
		private int n;
		private long count;

		public DSU(int n) {
			this.n = n;
			id = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public int root(int u) {
			while (u != id[u]) {
				id[u] = id[id[u]];
				u = id[u];
			}
			return u;
		}
        
        public boolean connected(int u, int v) {
            return root(u)==root(v);
        }

		public void union(int u, int v) {
			if (connected(u, v))
				return;

			int p = root(u);
			int q = root(v);

			count -= size[p] * 1L * (size[p] - 1);
			count -= size[q] * 1L * (size[q] - 1);

			id[p] = q;
			size[q] += size[p];
			count += size[q] * 1L * (size[q] - 1);
		}

	}
}