package model;

public final class Cart {
    private final int cartId;
    private int quantity;
    private double productPrice;
    private double totalAmount;

    public Cart(final int cartId, final int quantity, final double productPrice) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalAmount = totalAmount;
    }

    public int getCartId() {
        return cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount = quantity * productPrice;
    }

    public void setProductPrice(final double productPrice) {
        this.productPrice = productPrice;
    }

    public void setTotalAmount(final double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String toString(){
       return String.format("product id: %s | quantity: %d | product price: %f | product total Amount %f",
               getCartId(), getQuantity(), getProductPrice(), getTotalAmount());
    }
}