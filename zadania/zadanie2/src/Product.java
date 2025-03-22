public class Product {
    private String name;
    private int basePrice;
    private int discountPercentage;

    public Product(String name, int basePrice){
        this.name = name;
        this.basePrice = basePrice;
        this.discountPercentage = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getDiscountPercentage(){
        return this.discountPercentage;
    }

    public int getBasePrice(){
        return this.basePrice;
    }

    public void setName(String name){
        if(name != null) this.name = name;
    }

    public void setDiscountPercentage(int DiscountPercentage){
        if(DiscountPercentage >= 0 && DiscountPercentage <= 100) this.discountPercentage = DiscountPercentage;
    }

    public void setBasePrice(int basePrice){
        if(basePrice >= 0) this.basePrice = basePrice;
    }

    public int computePrice(){
        return (int)(this.basePrice * (1 - this.discountPercentage / 100.0));
    }
}
