class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                //System.out.println(box[i][j]);
                if(box[i][j] == '.'){
                      //System.out.println("inside condition1");
                    int k = j-1;
                    while(k>=0){
                        //System.out.println("inside condition2" + k);
                        if(box[i][k]=='#'){
                            //System.out.println("inside condition3");
                            box[i][k] = '.';
                            box[i][j] = '#';
                            break;
                        }
                        else if(box[i][k]=='*'){
                            break;
                        }
                        else{
                            k--;
                        }
                        
                    }
                }
            }
        }

        char[][] box2 = new char[n][m];
        for(int i = 0; i<m; ++i){
            for(int j = n-1; j>=0; --j)
                box2[j][m-i-1] = box[i][j];
        }
        return box2;
    }
}