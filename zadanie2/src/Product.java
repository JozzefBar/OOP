public class Product {
    private String name;
    private int basePrice;
    private int DiscountPercentage;

    public Product(String name, int basePrice){
        this.name = name;
        this.basePrice = basePrice;
        this.DiscountPercentage = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getDiscountPercentage(){
        return this.DiscountPercentage;
    }

    public int getBasePrice(){
        return this.basePrice;
    }

    public void setName(String name){
        if(name != null) this.name = name;
    }

    public void setDiscountPercentage(int DiscountPercentage){
        if(DiscountPercentage >= 0 && DiscountPercentage <= 100) this.DiscountPercentage = DiscountPercentage;
    }

    public void setBasePrice(int basePrice){
        if(basePrice > 0) this.basePrice = basePrice;
    }

    public int computePrice(){
        return (int)(this.basePrice*(double)(1 - this.DiscountPercentage/100));
    }
}
