package pl.gregorymartin.akademiaspringw2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile({"START","PLUS","PRO"})
class ProductService {
    List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
        productList.add(new Product("chleb", 3.49));
        productList.add(new Product("masło", 5.99));
        productList.add(new Product("ser", 5.49));
        productList.add(new Product("mleko", 2.99));
        productList.add(new Product("keczup", 3.49));

        System.out.println(productList);
    }

    public List<Product> getProductList() {
        return productList;
    }

}
