class ProductOfNumbers {
    ArrayList<Integer> list = new ArrayList<>();
    public ProductOfNumbers() {
        list.clear();
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            return;
        }
        int prev = (list.size()==0)?1: list.get(list.size()-1);
        list.add(prev * num);
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(k>n){
            return 0;
        }else if(k==n){
            return list.get(n-1);
        }else{
            return (list.get(n-1)/list.get(n-1-k));
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */