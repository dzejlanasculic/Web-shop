/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.validator;

import com.et.webshop.domain.Product;
import com.et.webshop.exception.ProductNotFoundException;
import com.et.webshop.service.ProductService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Džejlana Ščulić
 */
public class ProductIdValidator implements ConstraintValidator<ProductId, String>{
  @Autowired
  private ProductService productService;

  public void initialize(ProductId constraintAnnotation) {
    //  intentionally left blank; this is the place toinitialize the constraint annotation for any sensibledefault values.
  }

  public boolean isValid(String value,ConstraintValidatorContext context) {
    Product product;
    try {
      product =  productService.getProductById(value);
    }  catch (ProductNotFoundException e) {
      return true;
    }

    if(product!= null) {
      return false;
    }

    return true;
  }
}
