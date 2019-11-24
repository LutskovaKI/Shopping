import java.util.ArrayList;
import java.util.List;

public class Shopping {

    public static void main(String[] args) {

        Product[] products = new Product[] {
                new Product("Bread", 110),
                new Product("Sausage", 80),
                new Product("Butter", 70),
                new Product("Milk", 300),
                new Product("Potato", 40)
        };

        Product[] appliancesProducts = new Product[] {
                new Product("Sony", 100),
                new Product("Samsung", 80),
                new Product("Sharp", 70),
                new Product("Apple", 300),
                new Product("Acer", 40)
        };

        Shop[] shops = new Shop[] {
                new Shop(products),
                new Shop(appliancesProducts)
        };

        String[] requiredProductsList = new String[] {
                "Sony", "Bread", "Lenovo", "Onion"
        };

// Print all products from all shops
        System.out.println("Total list:");
        for (int i = 0; i < shops.length; i++) {
            for (int j = 0; j < shops[i].products.length; j++) {
                System.out.println(shops[i].products[j].name + " - " + shops[i].products[j].price);
            }
        }

// Print all bought products
        System.out.println("\nBought list:");
        float totalPrice = 0;
        for (int i = 0; i < shops.length; i++) {
            List<Product> boughtProducts = shops[i].buyProducts(requiredProductsList);
            for (int j = 0; j < boughtProducts.size(); j++) {
                Product boughtProduct = boughtProducts.get(j);
                totalPrice += boughtProduct.price;
                System.out.println(boughtProduct.name + " - " + boughtProduct.price);
            }
        }

        System.out.println("\nTotal price: " + totalPrice);
    }

}

class Shop {
    Product[] products;

    Shop(Product[] products) {
        this.products = products;
    }

    List<Product> buyProducts(String[] productNames) {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < productNames.length; i++) {
            String requiredProductName = productNames[i];
            for (int j = 0; j < products.length; j++) {
                Product product = products[j];
                if (requiredProductName.equals(product.name)) {
                    result.add(product);
                }
            }
        }
        return result;
    }
}

class Product {

    final String name;

    final float price;

    Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
