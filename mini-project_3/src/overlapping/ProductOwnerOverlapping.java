package overlapping;

public class ProductOwnerOverlapping extends ObjectPlusPlus{

    private String productName;

    public ProductOwnerOverlapping() {
    }

    public ProductOwnerOverlapping(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ProductOwner{" +
                "productName='" + productName + '\'' +
                '}';
    }

}
