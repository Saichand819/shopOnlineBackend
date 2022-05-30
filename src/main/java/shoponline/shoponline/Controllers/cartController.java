package shoponline.shoponline.Controllers;

import org.springframework.web.bind.annotation.*;
import shoponline.shoponline.Modals.productStructure;
import shoponline.shoponline.Services.CartService;
import shoponline.shoponline.Services.ProductService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
public class cartController {
    private CartService cartService;

    public cartController(){
        cartService = new CartService();
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cart")
    public List<productStructure> sayHelloWorld(HttpServletResponse response){
        return cartService.getAllCartProducts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cart/{id}")
    public List<productStructure> deleteAProductFromCart( @PathVariable() Integer id){
        return cartService.removeProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/cart/add-product")
    public productStructure createProductToCart(@RequestBody productStructure product){
        return cartService.addNewProductToCart(product);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/checkout")
    public List<productStructure> checkout(HttpServletResponse response){
        return cartService.checkout();
    }


}
