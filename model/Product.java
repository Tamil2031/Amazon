package model;

public final class Product {
    private String name;
    private  int id;
    private double price;

    public Product(final String name, final double price){
        this.name = name;
        this.price = price;
    }

    public void setName(final String name){
        this.name = name;
    }

    public final String getName(){
        return name;
    }

    public final int getId(){
        return id;
    }

    public final void setId(final int id){
        this.id = id;
    }

    public final void setPrice(final double price){
        this.price = price;
    }

    public final double getPrice(){
        return price;
    }

    public final void updateProduct(final String name, final double price){
        this.name = name;
        this.price = price;
    }

    public final String toString(){
        return String.format("product id: %d | product name: %s | product price: %f ",
                getId(), getName(), getPrice());

    }
}