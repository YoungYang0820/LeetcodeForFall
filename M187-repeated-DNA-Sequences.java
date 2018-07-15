class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet();
        HashSet<String> seen = new HashSet();
        for (int i = 0; i < s.length() - 9; i++) {
            String dna = s.substring(i, i + 10);
            if (!seen.add(dna)) {
                res.add(dna);
            }
        }
        return new LinkedList(res);
    }
}
