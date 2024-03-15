package com.atelier.productservice.controller;
import com.atelier.productservice.model.Product;
import com.atelier.productservice.model.Style;
import com.atelier.productservice.services.implementation.ProductServicesImpl;
import com.atelier.productservice.services.implementation.RelatedServicesImpl;
import com.atelier.productservice.services.implementation.StyleServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductsController {

    private ProductServicesImpl productServicesImpl;
    private RelatedServicesImpl relatedServicesImpl;
    private StyleServicesImpl styleServicesImpl;

    @Autowired
    public ProductsController(ProductServicesImpl productServicesImpl, RelatedServicesImpl relatedServicesImpl, StyleServicesImpl styleServicesImpl) {
        this.productServicesImpl = productServicesImpl;
        this.relatedServicesImpl = relatedServicesImpl;
        this.styleServicesImpl = styleServicesImpl;
    }

    //app.get('/products/:product_id', controller.productInfo);
    @GetMapping("/product/{product_id}")
    public ResponseEntity<Product> getProductInfo(@PathVariable Long product_id) throws IllegalArgumentException{
        Product product = productServicesImpl.getSpecificProduct(product_id);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productServicesImpl.getProducts();
        return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{product_id}/styles")
    public ResponseEntity<List<Style>> getProductStyles(@PathVariable Long product_id){
        List<Style> list = styleServicesImpl.getStylesOfProduct(product_id);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(){
        return new ResponseEntity<>("the argument provided is out of bounds", HttpStatus.UNAUTHORIZED);
    }

    //New Feature to implement once I have more time
    @GetMapping("/product/{product_id}/related")
    public ResponseEntity<List<Long>> getRelatedProducts(@PathVariable Long product_id){
        List<Long> relatedProducts = relatedServicesImpl.getRelatedProductIDs(product_id);
        return new ResponseEntity<>(relatedProducts, HttpStatus.ACCEPTED);
    }
}
