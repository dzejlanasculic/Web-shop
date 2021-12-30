/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.validator;

import com.et.webshop.domain.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component; 
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator; 
/**
 *
 * @author Džejlana Ščulić
 */
@Component
public class UnitsInStockValidator implements Validator{
    public boolean supports(Class<?> clazz) {
    return Product.class.isAssignableFrom(clazz);  
  }

  public void validate(Object target, Errors errors) {
    Product product =  (Product) target;

    if(product.getUnitPrice()!= null && new BigDecimal(10000).compareTo(product.getUnitPrice())<=0 &&product.getUnitsInStock()>99) {
      errors.rejectValue("unitsInStock","com.et.webshop.validator.UnitsInStockValidator.message");
    }
  }
}
