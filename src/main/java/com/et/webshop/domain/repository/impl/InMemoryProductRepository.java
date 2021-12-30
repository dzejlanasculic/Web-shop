package com.et.webshop.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.et.webshop.domain.Product;
import com.et.webshop.domain.repository.ProductRepository;
import com.et.webshop.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts =  new ArrayList<Product>();
  
  public InMemoryProductRepository() {
    Product Ruž =  new Product("P1234","Mat ruž za usne", new BigDecimal(50));
    Ruž.setDescription("Pink mat ruž za usne. Boja: roza. Broj 112 - Paris Paris. Dugotrajna formula, visokopigmentirana boja, ugodan osjećaj na usnama.");
    Ruž.setCategory("Ruž");
    Ruž.setManufacturer("L'Oréal Paris");
    Ruž.setUnitsInStock(1000);
  
    Product Puder =  new Product("P1235","Puder za lice", new BigDecimal(70));
    Puder.setDescription("3u1 tekući puder. Nijansa: 76 Warm Golden. Primer, korektor i puder u jednom proizvodu. Sadrži zaštitni faktor 20.");
    Puder.setCategory("Puder");
    Puder.setManufacturer("Max Factor");
    Puder.setUnitsInStock(1000);
    
    Product Maskara =  new Product("P1236","Maskara za oči", new BigDecimal(30));
    Maskara.setDescription("Extra black maskara za zadivljujući volumen trepavica bez grudvica. Sadržava kolagen i pčelinji vosak. Dermatološi i oftamološki testirano.");
    Maskara.setCategory("Maskara");
    Maskara.setManufacturer("Maybelline");
    Maskara.setUnitsInStock(1000);

    Product Tuš =  new Product("P1237","Tuš za oči", new BigDecimal(40));
    Tuš.setDescription("Tekući tuš za oči u olovci za precizno nanošenje. Mat efekat, vodootporan. Dugotrajnost. Dermatološki i oftamološki testiran.");
    Tuš.setCategory("Tuš");
    Tuš.setManufacturer("Aura");
    Tuš.setUnitsInStock(1000);
    
    listOfProducts.add(Ruž);
    listOfProducts.add(Puder);
    listOfProducts.add(Maskara);
    listOfProducts.add(Tuš);

  }

  public List<Product> getAllProducts() {
    return listOfProducts;
  }

  public Product getProductById(String productId) {
    Product productById =  null;
  
    for(Product product : listOfProducts) {
      if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
        productById =  product;
        break;
      }
    }    
    if(productById ==  null){
      throw new ProductNotFoundException("Nije pronađen proizvod sa id brojem: "+ productId);
    }   
    return productById;
}
  
 
  public List<Product> getProductsByCategory(String category) {
  List<Product> productsByCategory =  new ArrayList<Product>();
   
  for(Product product: listOfProducts) {
    if(category.equalsIgnoreCase(product.getCategory())){
      productsByCategory.add(product);
    }
  }  
  return productsByCategory;
}
  
  public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
    Set<Product> productsByBrand =  new HashSet<Product>();
    Set<Product> productsByCategory =  new HashSet<Product>();
    Set<String> criterias =  filterParams.keySet();    
    if(criterias.contains("brand")) {
      for(String brandName: filterParams.get("brand")) {
        for(Product product: listOfProducts) {
          if(brandName.equalsIgnoreCase(product.getManufacturer())){
            productsByBrand.add(product);
          }
        }
      }
    }
   
    if(criterias.contains("category")) {
      for(String category: filterParams.get("category")) {       
        productsByCategory.addAll(this.getProductsByCategory(category));
      }
    }
   
    productsByCategory.retainAll(productsByBrand);   
    return productsByCategory;
}

  public void addProduct(Product product) {
   listOfProducts.add(product);
}
  
}
	


