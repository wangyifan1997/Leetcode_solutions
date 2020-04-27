class Solution {
    private HashMap<Integer, Integer> map;
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new KeyComparator());
        for (Integer i: map.keySet()) {
            pq.add(i);
        }
        List<Integer> res = new LinkedList<Integer>();
        while (res.size() < k) {
            res.add(pq.poll());
        }
        return res;
        
    }
    
    
    class KeyComparator implements Comparator<Integer> {
        @Override
        // Since this is a minPQ we need to reverse order of sorting
        public int compare(Integer k1, Integer k2) {
            if (map.get(k1) > map.get(k2)) {
                return -1;
            } else if (map.get(k1) < map.get(k2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}