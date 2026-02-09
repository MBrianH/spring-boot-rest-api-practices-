package auca.ac.rw.restfullApiAssignment.controller.ecommerce;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "iPhone 14", "Latest Apple smartphone", 999.99, "Electronics", 50, "Apple"));
        products.add(new Product(2L, "Samsung Galaxy S23", "Android flagship phone", 899.99, "Electronics", 30, "Samsung"));
        products.add(new Product(3L, "MacBook Pro", "Professional laptop", 1999.99, "Electronics", 20, "Apple"));
        products.add(new Product(4L, "Nike Air Max", "Running shoes", 129.99, "Footwear", 100, "Nike"));
        products.add(new Product(5L, "Adidas Ultraboost", "Comfortable sneakers", 149.99, "Footwear", 80, "Adidas"));
        products.add(new Product(6L, "Sony Headphones", "Noise cancelling headphones", 299.99, "Electronics", 0, "Sony"));
        products.add(new Product(7L, "Levi's Jeans", "Classic denim jeans", 79.99, "Clothing", 150, "Levi's"));
        products.add(new Product(8L, "Canon Camera", "DSLR camera", 799.99, "Electronics", 15, "Canon"));
        products.add(new Product(9L, "Puma T-Shirt", "Sports t-shirt", 29.99, "Clothing", 200, "Puma"));
        products.add(new Product(10L, "Dell Monitor", "27 inch display", 349.99, "Electronics", 40, "Dell"));
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) Integer page, 
                                       @RequestParam(required = false) Integer limit) {
        if (page != null && limit != null) {
            int start = page * limit;
            int end = Math.min(start + limit, products.size());
            if (start >= products.size()) {
                return new ArrayList<>();
            }
            return products.subList(start, end);
        }
        return products;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return result;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return result;
    }

    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                result.add(product);
            }
        }
        return result;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                updatedProduct.setProductId(productId);
                products.set(i, updatedProduct);
                return ResponseEntity.ok(updatedProduct);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long productId, @RequestParam int quantity) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.remove(i);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
