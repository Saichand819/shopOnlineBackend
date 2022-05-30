package shoponline.shoponline.Services;

import shoponline.shoponline.Modals.productStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CartService {
    private List<productStructure> cartList = new ArrayList<>();

    public List<productStructure> getAllCartProducts(){
        return cartList;
    }

    public productStructure addNewProductToCart(productStructure product){
        productStructure x=new productStructure();
        x.setId(product.getId());
        x.setTitle(product.getTitle());
        x.setCategory(product.getCategory());
        x.setDescription(product.getDescription());
        x.setImage(product.getImage());
        x.setPrice(product.getPrice());
        cartList.add(x);
        return product;
    }

    public List<productStructure> removeProductById(Integer indexOfProduct){
        productStructure v = new productStructure();
        int inde=indexOfProduct;
        cartList.remove(inde);
        return cartList;
    }

    public List<productStructure> checkout(){
        cartList.removeAll(cartList);
        return this.getAllCartProducts();
    }


}
