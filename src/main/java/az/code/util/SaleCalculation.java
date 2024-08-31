package az.code.util;

import az.code.model.Product;
import az.code.model.PurchaseItem;

import java.math.BigDecimal;
import java.util.List;

public class SaleCalculation {
    public static BigDecimal calculate(List<PurchaseItem> purchaseItems, List<Product> products) {
        BigDecimal bigDecimalSum = BigDecimal.ZERO;
        for (int i = 0; i < purchaseItems.size(); i++) {
            long code = purchaseItems.get(i).getProductCode();
            for (int j = 0; j < products.size(); j++) {
                if (products.get(j).getCode() == code) {
                    bigDecimalSum = bigDecimalSum.add(products.get(i).getPrice()
                            .multiply(BigDecimal.valueOf(purchaseItems.get(i).getCount())));
                }
            }
        }
        return bigDecimalSum;
    }
}
