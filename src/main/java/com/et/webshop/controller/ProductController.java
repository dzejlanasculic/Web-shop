package com.et.webshop.controller;

import java.awt.image.renderable.RenderableImageProducer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.et.webshop.domain.Product;
import com.et.webshop.domain.repository.ProductRepository;
import com.et.webshop.service.ProductService;
import com.et.webshop.exception.NoProductsFoundUnderCategoryException;
import com.et.webshop.exception.ProductNotFoundException;
import com.et.webshop.validator.ProductValidator;
import com.et.webshop.validator.UnitsInStockValidator;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/products")
@Controller
public class ProductController {
 
@Autowired
private ProductValidator productValidator; 
 
  @Autowired
  private ProductService productService;
  
  @RequestMapping
  public String list(Model model) {
    model.addAttribute("products",productService.getAllProducts());
    return "products";
  }
  
  @RequestMapping("/all")
  public String allProducts(Model model) {
	  model.addAttribute("products",productService.getAllProducts());
	  return "products";
  }
  
  @RequestMapping("/{category}")
  public String getProductsByCategory(Model model,@PathVariable("category") String productCategory) {
	   List<Product> products =productService.getProductsByCategory(productCategory);

  if (products ==  null || products.isEmpty()) {
    throw new NoProductsFoundUnderCategoryException();
  }

  model.addAttribute("products", products);
  return "products";
  }
  
  @RequestMapping("/filter/{ByCriteria}")
  public String getProductsByFilter(Model model, @MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams) {
	  model.addAttribute("products",productService.getProductsByFilter(filterParams));
		  return "products";
  }
  
  @RequestMapping("/product")
  public String getProductById(Model model, @RequestParam("id") String productId) {
	  model.addAttribute("product",productService.getProductById(productId));
	  return "product";
  }
  
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String getAddNewProductForm(Model model) {
	  Product newProduct = new Product();
	  model.addAttribute("newProduct",newProduct);
	  return "addProduct";
  }
   
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String proccessAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result) {
	if(result.hasErrors()) {
             return "addProduct";
        }  
      String[] suppressedFields = result.getSuppressedFields();
	  if(suppressedFields.length > 0) {
		  throw new RuntimeException("Pokušaj povezivanja nedopuštenih polja: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
	  }
       
	  productService.addProduct(newProduct);
	  return "redirect:/products";
  }

  @InitBinder
  public void initialiseBinder(WebDataBinder binder) {
	  binder.setDisallowedFields("unitsInOrder", "discontinued");
          binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock", "condition", "language");
          binder.setValidator(productValidator);
  }
  
}

