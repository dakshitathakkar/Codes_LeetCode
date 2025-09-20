class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] matrix = new int[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
            matrix[i][i] = 0;
        }
        for(int i=0;i<cost.length;i++){
            matrix[original[i]-'a'][changed[i]-'a'] = cost[i];
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                if(matrix[i][k]<Integer.MAX_VALUE){
                    for(int j = 0;j<26;j++){
                    if(matrix[k][j]<Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }

                }
                }
                
            }
        }
        long ans = 0;
        for(int i=0;i<source.length();i++){
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if(matrix[s][t] == Integer.MAX_VALUE){
                return -1;
            }
            ans += matrix[s][t];
        }

        return ans;
    }
}