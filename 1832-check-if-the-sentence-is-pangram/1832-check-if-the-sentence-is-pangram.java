class Solution {
    public boolean checkIfPangram(String sentence) {
         int arr[] = new int[26];
        for (int i =0; i<sentence.length(); i++){
            char ch=sentence.charAt(i);
            arr[ch-'a']++;
        }
        for (int j =0; j<26; j++){
            if (arr[j]==0)
            return false;
        }
        return true;
    }
}