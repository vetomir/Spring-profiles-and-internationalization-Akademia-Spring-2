package pl.gregorymartin.akademiaspringw2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("PRO")
class ProductServicePro {

    private ProductService service;

    @Value("${page-info.price.discount}")
    private String discount;

    public ProductServicePro(final ProductService service) {
        this.service = service;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
        service.getProductList()
                .forEach(x -> {
                    calcpriceWithDiscount(x);
                    System.out.println("produkt: " + x.getName() + " cena ze zniżką: " + x.getPriceWithDiscount());
                });
    }

    private void calcpriceWithDiscount(final Product source) {
        BigDecimal priceWithDiscount = BigDecimal.valueOf(source.getPrice())
                .multiply(
                        new BigDecimal(String.valueOf(1.0 - Double.parseDouble("0." + discount))));

        priceWithDiscount = priceWithDiscount.setScale(2,
                BigDecimal.ROUND_HALF_EVEN);

        source.setPriceWithDiscount(priceWithDiscount.doubleValue());
    }
}
