class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap();
        for (String string : strings) {
            String temp = getTemp(string);
            List<String> list = map.getOrDefault(temp, new LinkedList());
            list.add(string);
            map.put(temp, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String getTemp(String string) {
        int d = string.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) < string.charAt(0)) sb.append(string.charAt(i) - d + 26);
            else sb.append(string.charAt(i) - d);
        }
        return sb.toString();
    }
}
