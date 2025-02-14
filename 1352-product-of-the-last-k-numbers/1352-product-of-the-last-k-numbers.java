class ProductOfNumbers {
    ArrayList<Integer> arr;
    public ProductOfNumbers() {
        arr = new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        int n = arr.size();
        if(num!=0){
            arr.add(arr.get(n-1)*num);
        }
        else{
        arr = new ArrayList<>();
        arr.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = arr.size();

        if(k<n){
            return arr.get(n-1)/arr.get(n-k-1);
        }
        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */