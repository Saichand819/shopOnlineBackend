package shoponline.shoponline.Services;


import shoponline.shoponline.Modals.productStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductService {
    private List<productStructure> productList = new ArrayList<>();

    public ProductService(){
        productStructure x=new productStructure();
        x.setId(1);
        x.setTitle("hey");
        x.setCategory("hey");
        x.setDescription("hey");
        x.setImage("hey");
        x.setPrice(200);
        productList.add(x);
    }

    public List<productStructure> getAllProducts(){
        return productList;
    }

    public productStructure getProductById(Integer id){
        List<productStructure>v = productList.stream()
                                        .filter(a-> Objects.equals(a.getId(),id))
                                        .collect(Collectors.toList());
        return v.get(0);
    }

    public productStructure addNewProduct(productStructure product){
        productStructure x=new productStructure();
        x.setId(product.getId());
        x.setTitle(product.getTitle());
        x.setCategory(product.getCategory());
        x.setDescription(product.getDescription());
        x.setImage(product.getImage());
        x.setPrice(product.getPrice());
        this.productList.add(x);
        return product;
    }


}
