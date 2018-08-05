/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        ArrayList<Integer> list = new ArrayList();
        helper(nestedList, 1, list);

        int res = 0;
        int depth = list.size();
        for (int i = 0; i < depth; i++) {
            res += (depth - i) * list.get(i);
        }
        return res;
    }

    private void helper(List<NestedInteger> nestedList, int depth, ArrayList<Integer> list) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                if (depth > list.size()) {
                    while (list.size() < depth - 1) list.add(0);
                    list.add(nest.getInteger());
                }
                else {
                    list.set(depth - 1, list.get(depth - 1) + nest.getInteger());
                }
            }
            else {
                helper(nest.getList(), depth + 1, list);
            }
        }
    }
}
