package pl.gregorymartin.akademiaspringw2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("PLUS")
class ProductServicePlus {

    @Value("${page-info.price.taxes}")
    private String taxes;

    private ProductService service;

    public ProductServicePlus( final ProductService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
        this.service.getProductList()
                .forEach(x -> {
                    calcPriceWithVat(x);
                    System.out.println("produkt: " + x.getName() + " cena z VAT: " + x.getPriceWithVat());
                });
    }


    private void calcPriceWithVat(final Product source) {
        BigDecimal priceWithVat = BigDecimal.valueOf(source.getPrice())
                .multiply(
                        new BigDecimal("1." + taxes));

        priceWithVat = priceWithVat.setScale(2,
                BigDecimal.ROUND_HALF_EVEN);

        source.setPriceWithVat( priceWithVat.doubleValue() );
    }
}
