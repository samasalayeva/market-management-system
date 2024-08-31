package az.code.util;

import az.code.model.Product;

import java.util.List;

public class SearchUtil {
    public static Product searchProductCount(List<Product> products, long code) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode() == code) {
                product = products.get(i);
            }
        }
        return product;
    }
}
