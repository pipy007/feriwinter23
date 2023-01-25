package si.um.feri.measurements.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import si.um.feri.measurements.dto.Product;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController controller;
    Product newProd = new Product(0, "testna meritev", 10, -10);

    @BeforeEach
    void setUp() {
        ResponseEntity<si.um.feri.measurements.dto.Product>  res = controller.postProduct(newProd);
    }

    @Test
    void getAllProducts() {
        Iterable<Product> products = controller.getAllProducts();
        assertNotNull(products);
        System.out.println(products);
    }

    @Test
    void getProductById() {
        /*ResponseEntity<Product> res = controller.getProductById(1);
        assertNotNull(res);
        assertNotNull(res.getBody());
        assertEquals(1, res.getBody().id());*/
    }

    @Test
    void postProduct() {
        Product newProd2 = new Product(0, "meritev1", 10, -10);
        ResponseEntity<si.um.feri.measurements.dto.Product>  res = controller.postProduct(newProd2);
        assertNotNull(res);
        assertNotNull(res.getBody());
    }

    @Test
    void putProduct() {
        Product newProd3 = new Product(-1, "popravljena testna meritev", 10, -10);
        ResponseEntity<si.um.feri.measurements.dto.Product>  res = controller.putProduct(-1, newProd3);
        assertNotNull(res);
        assertNotNull(res.getBody());
    }

    @Test
    void deleteProduct() {
        Product newProd3 = new Product(-3, "popravljena testna meritev", 10, -10);
        ResponseEntity<si.um.feri.measurements.dto.Product>  res = controller.putProduct(-3, newProd3);
        assertNotNull(res);
        assertNotNull(res.getBody());
        ResponseEntity<String>  res2 = controller.deleteProduct(-3);
        assertNotNull(res2);
        assertNotNull(res2.getBody());
    }
}