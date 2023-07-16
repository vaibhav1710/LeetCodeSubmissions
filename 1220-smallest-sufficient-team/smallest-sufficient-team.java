class Solution {
   int[][] dp;
    boolean[][] taken;
    int req_mask, m;

    public int solve(List<Integer> people, int i, int mask) {
        if (mask == req_mask)
            return 0;
        if (i == m)
            return 10000;
        if (dp[mask][i] != -1)
            return dp[mask][i];
        int ans1 = solve(people, i + 1, mask | people.get(i)) + 1;
        int ans2 = solve(people, i + 1, mask);
        if (ans1 < ans2)
           taken[mask][i] = true;
        return dp[mask][i] = Math.min(ans1, ans2);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people_skills) {
        int n = req_skills.length;
        m = people_skills.size();

        HashMap<String, Integer> skills = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skills.put(req_skills[i], i);
        }

        List<Integer> people = new ArrayList<>();
        for (List<String> v : people_skills) {
            int h = 0;
            for (String skill : v)
                h |= 1 << skills.get(skill);
            people.add(h);
        }

        req_mask = (1 << n) - 1;
        dp = new int[1 << n][m];
        taken = new boolean[1 << n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        solve(people, 0, 0);

        List<Integer> ans = new ArrayList<>();
        int mask = 0;
        for (int i = 0; i < m; i++) {
            if (taken[mask][i]) {
                ans.add(i);
                mask |= people.get(i);
            }
            if (mask == req_mask)
                break;
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            result[i] = ans.get(i);

        return result;
    }
}