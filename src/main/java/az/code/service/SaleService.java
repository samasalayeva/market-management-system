package az.code.service;

import az.code.model.Product;
import az.code.model.Purchase;
import az.code.model.PurchaseItem;
import az.code.util.SaleCalculation;
import az.code.util.ScannerUtil;
import az.code.util.SearchUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleService {
    private List<Purchase> purchases = new ArrayList<>();
    private List<PurchaseItem> purchaseItems = new ArrayList<>();


    public void addSale(List<Product> products) {
        Purchase purchase = new Purchase();

        System.out.println("please enter id");
        purchase.setId(ScannerUtil.inputInt());

        purchase.setCreationDate(LocalDate.now());

        System.out.println("please enter how many types of products will be: ");
        int countProduct = ScannerUtil.inputInt();

        for (int i = 0; i < countProduct; i++) {
            System.out.println("please enter purchase item id");
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setId(ScannerUtil.inputLong());

            System.out.println("please enter product code");
            long code = ScannerUtil.inputLong();
            purchaseItem.setProductCode(code);

            Product product = SearchUtil.searchProductCount(products, code);
            int productCount = product.getCount();

            System.out.println("please enter product count");
            int purchaseCount = ScannerUtil.inputInt();
            purchaseItem.setCount(purchaseCount);


            if (productCount >= purchaseCount) {
                int newProductCount = productCount - purchaseCount;
                product.setCount(newProductCount);
            } else {
                System.out.println("this product has not enough at market");
            }


            purchaseItems.add(purchaseItem);

        }

        purchase.setPurchaseItems(purchaseItems);
        purchase.setTotalPrice(SaleCalculation.calculate(purchaseItems, products));
        purchases.add(purchase);

    }

    public void returnSale(List<Product> products) {
        System.out.println("Please enter the code of the product you want to return: ");
        long code = ScannerUtil.inputLong();
        Product product = SearchUtil.searchProductCount(products, code);

        if (product != null) {
            System.out.println("Please enter the number of products you want to return: ");
            int count = ScannerUtil.inputInt();
            int newCount;

            PurchaseItem purchaseItem = null;
            Purchase purchase = null;


            for (int i = 0; i < purchases.size(); i++) {
                for (int j = 0; j < purchaseItems.size(); j++) {
                    if (purchases.get(i).getPurchaseItems().get(j).getProductCode() == code) {
                        purchaseItem = purchases.get(i).getPurchaseItems().get(j);
                        purchase = purchases.get(i);
                        break;
                    }
                }

            }

            if (purchaseItem != null && purchaseItem.getCount() >= count) {
                newCount = purchaseItem.getCount() - count;
                purchaseItem.setCount(newCount);
                product.setCount(product.getCount() + count); // Update the product count
                purchase.setTotalPrice(SaleCalculation.calculate(purchaseItems, products));
            } else {
                System.out.println("The requested count is not available or the product was not found in purchases.");
            }
        } else {
            System.out.println("Product not found.");
        }

    }

    public void removeSale(List<Product> products) {
        System.out.println("Please enter the code of the product you want to remove in sale: ");
        Long code = ScannerUtil.inputLong();
        Product product = SearchUtil.searchProductCount(products, code);

        PurchaseItem purchaseItem = null;


        for (int i = 0; i < purchaseItems.size(); i++) {
            if (purchaseItems.get(i).getProductCode() == product.getCode()) {
                purchaseItem = purchaseItems.get(i);
                break;
            }
        }


        if (purchaseItem != null) {
            purchaseItems.remove(purchaseItem);
            System.out.println(purchaseItem + " removed sales");
        } else {
            System.out.println("this sale is not available");
        }
    }

    public void showAllSales() {
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public void showSalesByTwoDateRange() {
        System.out.println("Please enter the begin date in this format yyyy-mm-dd (2005-11-13):");
        String beginDateStr = ScannerUtil.inputString();
        LocalDate beginDate = LocalDate.parse(beginDateStr);

        System.out.println("Please enter the last date in this format yyyy-mm-dd (2010-09-23):");
        String lastDateStr = ScannerUtil.inputString();
        LocalDate lastDate = LocalDate.parse(lastDateStr);

        for (int i = 0; i < purchases.size(); i++) {
            LocalDate date = purchases.get(i).getCreationDate();
            if (date.compareTo(beginDate) >= 0 && date.compareTo(lastDate) <= 0) {
                System.out.println(purchases.get(i));
            }
        }

    }

    public void showSalesByTwoPriceRange() {
        System.out.println("Please enter the lower price of the range:");
        BigDecimal price1 = ScannerUtil.inputBigDecimal();

        System.out.println("Please enter the higher price of the range:");
        BigDecimal price2 = ScannerUtil.inputBigDecimal();

        for (int i = 0; i < purchases.size(); i++) {
            BigDecimal totalPrice = purchases.get(i).getTotalPrice();
            if (totalPrice.compareTo(price1) >= 0 && totalPrice.compareTo(price2) <= 0) {
                System.out.println(purchases.get(i));
            }
        }
    }

    public void showSalesByDate() {
        System.out.println("please enter date which you want to find this format yyyy-mm-dd (2010-09-23)");
        String dateStr = ScannerUtil.inputString();
        LocalDate date = LocalDate.parse(dateStr);

        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getCreationDate().equals(date)) {
                System.out.println(purchases.get(i));
            }
        }


    }

    public void showSalesById() {
        System.out.println("please enter id of sale");
        long id = ScannerUtil.inputLong();

        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getId() == id) {
                System.out.println(purchases.get(i));
            }
        }
    }

}
