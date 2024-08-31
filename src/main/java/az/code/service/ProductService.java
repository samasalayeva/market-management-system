package az.code.service;

import az.code.manage.ProductManager;
import az.code.model.Product;
import az.code.util.EnumNameUtil;
import az.code.util.ScannerUtil;

import java.math.BigDecimal;
import java.util.*;

import static az.code.manage.ProductManager.chooseAndEnterByCategory;

public class ProductService {
     private static List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        System.out.println("1 - add product");

        System.out.println("enter product name");
        product.setName(ScannerUtil.inputString());

        chooseAndEnterByCategory(product);

        System.out.println("enter product count");
        product.setCount(ScannerUtil.inputInt());

        System.out.println("enter product code");
        product.setCode(ScannerUtil.inputInt());

        System.out.println("enter product price");

        product.setPrice(ScannerUtil.inputBigDecimal());

        products.add(product);
    }

    public void removeProduct() {
        System.out.println("please enter id which you wanna remove");
        int code = ScannerUtil.inputInt();
        int index = -1;
        ListIterator<Product> productIterator = products.listIterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getCode() == code) {
                index = productIterator.previousIndex();
            }
        }
        if (index == -1) {
            System.out.println("this product is not available");
        } else {
            Product remove = products.remove(index);
            System.out.println("product removed " + remove);
        }

    }

    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void update() {
        System.out.println("please enter code which you want to change product");
        int code = ScannerUtil.inputInt();

        for (Product product : products) {
            if (product.getCode() == code) {

                System.out.println("if you don't want change name, press enter ");
                String newName = ScannerUtil.inputString();
                if (newName.isEmpty()) {
                    newName = product.getName();
                }

                System.out.println("if you don't want change count, press enter ");
                String strCount = ScannerUtil.inputString();
                int newCount = product.getCount();
                if (!strCount.isEmpty()) {
                    newCount = Integer.valueOf(strCount);
                }

                System.out.println("if you don't want change code, press enter ");
                String strCode = ScannerUtil.inputString();

                long newCode = product.getCode();
                if (!strCode.isEmpty()) {
                    newCode = Long.valueOf(strCode);
                }

                System.out.println("if you don't want change price, press enter ");
                String strPrice = ScannerUtil.inputString();

                BigDecimal newPrice = product.getPrice();
                if (!strPrice.isEmpty()) {
                    long strPriceParse = Long.valueOf(strPrice);
                    newPrice = BigDecimal.valueOf(strPriceParse);
                }

                System.out.println("if you don't want change category, press enter otherwise you can write 1 or any alphanumeric");
                String strCategory = ScannerUtil.inputString();

                if (!strCategory.isEmpty()) {
                    chooseAndEnterByCategory(product);
                }


                product.setCount(newCount);
                product.setName(newName);
                product.setCode(newCode);
                product.setPrice(newPrice);

                break;
            }
        }

    }

    public void showAllProductsByCategory() {
        ProductManager.printCategories();
        int categoryNumber = ScannerUtil.inputInt();
        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductType() == EnumNameUtil.choseType(categoryNumber)) {
                productList.add(products.get(i));
            } else {
                System.out.println("please enter correct number");
            }
        }

        if (!productList.isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i));
            }
        } else {
            System.out.println("The product of this category is not available in the market");
        }

    }

    public void showProductsByPriceRange() {
        System.out.println("please enter min price");
        BigDecimal min = ScannerUtil.inputBigDecimal();

        System.out.println("please enter max price");
        BigDecimal max = ScannerUtil.inputBigDecimal();


        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            BigDecimal b = products.get(i).getPrice();
            if (b.compareTo(min) >= 0 && b.compareTo(max) <= 0) {
                productList.add(products.get(i));
            }
        }

        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
        if(productList.isEmpty()){
            System.out.println("There is no product between the 2 prices");
        }
    }

    public void searchByName(){
        System.out.println("please enter product name");
        String name = ScannerUtil.inputString();

        for (int i = 0; i < products.size(); i++) {
            if(Objects.equals(products.get(i).getName(), name)){
                System.out.println(products.get(i));
            }
        }
    }

    public static List<Product> getProducts(){
        return products;
    }

}

