package filemanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(inputProduct(line));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't read file!", ioException);
        }
    }

    public void writePriceOverToFile(Path path, int priceThreshold) {
        try {
            Files.write(path, selectProductsByPrice(priceThreshold));
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't write file!", ioException);
        }
    }

    private List<String> selectProductsByPrice(int priceThreshold) {
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() > priceThreshold) {
                result.add(product.getProductID()+";"+product.getName()+";"+product.getPrice());
            }
        }
        return result;
    }

    private Product inputProduct(String line) {
        String id = line.split(";")[0];
        String name = line.split(";")[1];
        int price = Integer.parseInt(String.valueOf(line.split(";")[2]));
        return new Product(id, name, price);
    }
}
