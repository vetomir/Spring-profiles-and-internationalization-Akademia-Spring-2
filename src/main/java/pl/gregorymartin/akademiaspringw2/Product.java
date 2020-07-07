package pl.gregorymartin.akademiaspringw2;

import java.math.BigDecimal;

class Product {
    private String name;
    private double price;
    private double priceWithVat;
    private double priceWithDiscount;

    public Product(final String name, final double price) {
        this.name = name;
        this.price = price;
    }





    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public double getPriceWithVat() {
        return priceWithVat;
    }

    public void setPriceWithVat(final double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(final double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", priceWithVat=" + priceWithVat +
                ", priceWithDiscount=" + priceWithDiscount +
                '}';
    }
}
