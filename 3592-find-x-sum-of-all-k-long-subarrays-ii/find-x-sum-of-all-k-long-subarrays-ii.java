import java.util.*;
class MyBean {
    public long val;
    public long freq;

    public MyBean(long val, long freq) {
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        TreeSet<MyBean> ts1 = new TreeSet<>((b1, b2) -> {
            if (b1.freq != b2.freq) {
                return (b1.freq < b2.freq) ? -1 : 1;
            } else if (b1.val < b2.val) {
                return -1;
            } else if (b1.val > b2.val) {
                return 1;
            } else {
                return 0;
            }
        });


         TreeSet<MyBean> ts2 = new TreeSet<>((b1, b2) -> {
            if (b1.freq != b2.freq) {
                return (b1.freq < b2.freq) ? 1 : -1;
            } else if (b1.val < b2.val) {
                return 1;
            } else if (b1.val > b2.val) {
                return -1;
            } else {
                return 0;
            }
        });

        Map<Long, Long> freqMap = new HashMap<>();
        long total = 0;
        int n = nums.length;
        long result[] = new long[n - k + 1];

        for (int i = 0; i < k; i++) {

            if (freqMap.containsKey((long)nums[i])) {
                if (ts1.contains(new MyBean((long)nums[i], freqMap.get((long)nums[i])))) {
                    total = total - (((long)nums[i]) * freqMap.get((long)nums[i]));
                }
                ts1.remove(new MyBean((long)nums[i], freqMap.get((long)nums[i])));
                ts2.remove(new MyBean((long)nums[i], freqMap.get((long)nums[i])));
            }
            freqMap.put((long)nums[i], freqMap.getOrDefault((long)nums[i], (long)0) + 1);

            ts2.add(new MyBean((long)nums[i], freqMap.get((long)nums[i])));

            while (ts1.size() < x && !ts2.isEmpty()) {
                MyBean top = ts2.pollFirst();
                ts1.add(top);
                total = total + (top.freq * top.val);
            }

            while (!ts2.isEmpty()) {
                MyBean top1 = ts1.first();
                MyBean top2 = ts2.first();

                if (compare(top2, top1) > 0) {
                    ts1.pollFirst();
                    ts2.pollFirst();
                    total = total - (top1.freq * top1.val);
                    ts1.add(top2);
                    ts2.add(top1);
                    total = total + (top2.freq * top2.val);
                } else {
                    break;
                }
            }
        }

        result[0] = total;

        for (int i = k; i < n; i++) {
            if (ts1.contains(new MyBean((long)nums[i - k], freqMap.get((long)nums[i - k])))) {
                total = total - (((long)nums[i - k]) * freqMap.get((long)nums[i - k]));
            }
            ts1.remove(new MyBean((long)nums[i - k], freqMap.get((long)nums[i - k])));
            ts2.remove(new MyBean((long)nums[i - k], freqMap.get((long)nums[i - k])));
            freqMap.put((long)nums[i - k], freqMap.getOrDefault((long)nums[i - k], (long)0) - 1);

            if (freqMap.get((long)nums[i - k]).intValue() > 0) {
                ts2.add(new MyBean((long)nums[i - k], freqMap.get((long)nums[i - k])));
            }


             if (freqMap.containsKey((long)nums[i])) {
                if (ts1.contains(new MyBean((long)nums[i], freqMap.get((long)nums[i])))) {
                    total = total - (((long)nums[i]) * freqMap.get((long)nums[i]));
                }
                ts1.remove(new MyBean((long)nums[i], freqMap.get((long)nums[i])));
                ts2.remove(new MyBean((long)nums[i], freqMap.get((long)nums[i])));
            }
            freqMap.put((long)nums[i], freqMap.getOrDefault((long)nums[i], (long)0) + 1);

            ts2.add(new MyBean((long)nums[i], freqMap.get((long)nums[i])));

            while (ts1.size() < x && !ts2.isEmpty()) {
                MyBean top = ts2.pollFirst();
                ts1.add(top);
                total = total + (top.freq * top.val);
            }

            while (!ts2.isEmpty()) {
                MyBean top1 = ts1.first();
                MyBean top2 = ts2.first();

                if (compare(top2, top1) > 0) {
                    ts1.pollFirst();
                    ts2.pollFirst();
                    total = total - (top1.freq * top1.val);
                    ts1.add(top2);
                    ts2.add(top1);
                    total = total + (top2.freq * top2.val);
                } else {
                    break;
                }
            }

            result[i - k + 1] = total;
        }

        return result;
    }

    public int compare(MyBean b1, MyBean b2) {
        if (b1.freq != b2.freq) {
            return (b1.freq < b2.freq) ? -1 : 1;
        } else if (b1.val < b2.val) {
            return -1;
        } else if (b1.val > b2.val) {
            return 1;
        } else {
            return 0;
        }
    }
}