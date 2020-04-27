class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] temp;
        String key;
        for (String str: strs) {
            temp = str.toCharArray();
            Arrays.sort(temp);
            key = new String(temp);
            List<String> res = map.get(key);
            if (res == null) {
            	res = new LinkedList<>();
            	res.add(str);
            	map.put(key, res);
            } else {
            	res.add(str);
            }
        }
        return new ArrayList(map.values());
    }
}
