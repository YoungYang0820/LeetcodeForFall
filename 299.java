class Solution {
    public String getHint(String secret, String guess) {
        int n  = secret.length();
        int a = 0, b = 0;
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        for(int i = 0; i < n; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                a++;
            }else{
                num1[secret.charAt(i) - '0']++;
                num2[guess.charAt(i)-'0']++;
            }
            
        }
        for(int i = 0; i < 10; i++){
            b += Math.min(num1[i], num2[i]);
        }
        String res = Integer.toString(a) +'A'+ Integer.toString(b) +'B';
        return res;
        
    }
}
