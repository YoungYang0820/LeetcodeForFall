class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        if (k == 0) return s;
        HashMap<Character, Integer> map = new HashMap();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (pq.size() == 0) return "";
            Map.Entry<Character, Integer> entry = pq.remove();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);

            queue.offer(entry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> e = queue.poll();
                if (e.getValue() > 0) {
                    pq.add(e);
                }
            }
        }
        return sb.toString();
    }
}
