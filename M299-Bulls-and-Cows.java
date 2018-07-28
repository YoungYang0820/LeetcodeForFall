class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else map[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && map[guess.charAt(i) - '0'] > 0) {
                cows++;
                map[guess.charAt(i) - '0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
