class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String dup = new String(arr);
        arr = t.toCharArray();
        Arrays.sort(arr);
        return (dup.equals(new String(arr)));
    }
}