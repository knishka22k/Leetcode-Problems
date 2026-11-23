class ProductOfNumbers {
    List<Integer> product;
    public ProductOfNumbers() {
        product = new ArrayList<>();
        product.add(1);
    }
    
    public void add(int num) {
        int n = product.size();
        if(num == 0){
            product.clear();
            product.add(1);
            return;
        }
        product.add(product.get(n-1)*num);
    }
    
    public int getProduct(int k) {
        int n = product.size();
        if(k>=n){
            return 0;
        }
        return product.get(n-1) / product.get(n-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */