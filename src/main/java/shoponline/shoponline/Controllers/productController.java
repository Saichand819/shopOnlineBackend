package shoponline.shoponline.Controllers;

import org.springframework.web.bind.annotation.*;
import shoponline.shoponline.Services.ProductService;
import shoponline.shoponline.Modals.productStructure;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class productController {

    private ProductService productService;

    public productController(){
        productService = new ProductService();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/products")
    public List<productStructure> getTheProducts(HttpServletResponse response){
        return productService.getAllProducts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/products/{id}")
    public productStructure onlyOneProduct( @PathVariable() Integer id){
        return productService.getProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/products/add-product")
    public productStructure createProduct(@RequestBody productStructure product){
        return productService.addNewProduct(product);
    }

}
