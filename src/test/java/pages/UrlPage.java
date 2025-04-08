package pages;

/**
 * Класс UrlPage, содержащий статические URL-адреса,
 * используемые в приложении.
 * Включает URL для главной страницы, страницы корзины,
 * страницы заказа и метод для получения URL продукта по его идентификатору.
 */
public class UrlPage {
    public static final String PRODUCT_URL_20 = "https://algosstile.github.io/vue-app/index.html#/product/20";
    public static final String MAIN_URL = "https://algosstile.github.io/vue-app/index.html#/";
    public static final String CART_URL = "https://algosstile.github.io/vue-app/index.html#/cart";
    public static final String ORDER_URL = "https://algosstile.github.io/vue-app/index.html#/order";

    public static String getProductUrl(String productId) {
        return "https://algosstile.github.io/vue-app/index.html#/product/" + productId;
    }
}

