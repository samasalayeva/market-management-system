package az.code.manage;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.service.ProductService;
import az.code.util.ScannerUtil;

import java.util.EnumSet;

public class ProductManager {
    static ProductService productService = new ProductService();

    public static void productManage(int command) {
        Product product = new Product();

        switch (command) {
            case 1 -> {
                productService.addProduct(product);
            }
            case 2 -> {
                productService.update();
            }
            case 3 -> {
                productService.removeProduct();
            }
            case 4 -> {
                productService.showAllProducts();
            }
            case 5 -> {
                productService.showAllProductsByCategory();
            }
            case 6 -> {
                productService.showProductsByPriceRange();
            }
            case 7 -> {
                productService.searchByName();
            }
            case 8 -> {
                MainManager.manageMarket();
            }
            default -> System.out.println("invalid number");
        }
    }


    public static void printProductOpMenu() {
        System.out.println("1 - add product");
        System.out.println("2 - update product");
        System.out.println("3 - remove product");
        System.out.println("4 - show all product");
        System.out.println("5 - show all product by category");
        System.out.println("6 - show products by price range");
        System.out.println("7 - search by name");
        System.out.println("8 - exit");
        productManage(ScannerUtil.inputInt());

    }

    public static void chooseAndEnterByCategory(Product product) {
        printCategories();
        int number = ScannerUtil.inputInt();
        switch (number) {
            case 1 -> product.setProductType(ProductType.FOOD);
            case 2 -> product.setProductType(ProductType.DRINK);
            case 3 -> product.setProductType(ProductType.SWEET);
            case 4 -> product.setProductType(ProductType.MEAT);
            default -> System.out.println("please enter correct number");
        }
    }

    public static void printCategories() {
        int i = 1;
        for (ProductType info : EnumSet.allOf(ProductType.class)) {
            System.out.println(info + " - " + i++);
        }
        System.out.println("please select a product category");
    }
}
