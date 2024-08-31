package az.code.manage;

import az.code.service.ProductService;
import az.code.service.SaleService;
import az.code.util.ScannerUtil;


public class SaleManager {
    static SaleService saleService = new SaleService();

    public static void saleManage(int command) {
        switch (command) {
            case 1 -> {
                saleService.addSale(ProductService.getProducts());
            }
            case 2 -> {
                saleService.returnSale(ProductService.getProducts());
            }
            case 3 -> {
                saleService.removeSale(ProductService.getProducts());
            }
            case 4 -> {
                saleService.showAllSales();
            }
            case 5 -> {
                saleService.showSalesByTwoDateRange();
            }
            case 6 -> {
                saleService.showSalesByTwoPriceRange();
            }
            case 7 -> {
                saleService.showSalesByDate();
            }
            case 8 -> {
                saleService.showSalesById();
            }
            case 9 -> {
                MainManager.manageMarket();
            }
        }
    }

    public static void printSaleOpMenu() {

        System.out.println("1 - add sale");
        System.out.println("2 - return sale");
        System.out.println("3 - remove sale");
        System.out.println("4 - show all sales");
        System.out.println("5 - show sales by two date range");
        System.out.println("6 - show sales by two price range");
        System.out.println("4 - show sales by date");
        System.out.println("8 - show sales by id");
        System.out.println("9 - exit");
        saleManage(ScannerUtil.inputInt());
    }


}
