class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] idx = new int[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }
        boolean[] seen = new boolean[org.length + 1];
        int pairs = org.length - 1;
        boolean isEmpty = true;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int curr = seq.get(i);
                if (curr < 1 || curr > org.length) return false;
                if (i == 0) continue;
                int prev = seq.get(i - 1);
                if (idx[prev] >= idx[curr]) return false;
                else if (idx[prev] + 1 == idx[curr]) {
                    if (!seen[prev]) {
                        seen[prev] = true;
                        pairs--;
                    }
                }
            }
        }
        return pairs == 0 && !isEmpty;
    }
}
