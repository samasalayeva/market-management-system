package az.code.util;

import az.code.model.ProductType;

public class EnumNameUtil {
    public static ProductType choseType(int number){
        ProductType productType = null;
        if(number == 1){
            productType = ProductType.FOOD;
        }else if(number == 2){
            productType = ProductType.DRINK;
        } else if (number == 3) {
            productType = ProductType.SWEET;
        } else if (number == 4) {
            productType = ProductType.MEAT;
        }
        return productType;
    }
}
