class TwoSum {
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            int num2 = value - num;
            if (num == num2) {
                if (map.get(num) > 1) return true;
            }
            else {
                if (map.containsKey(num2)) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
