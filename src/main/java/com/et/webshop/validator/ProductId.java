/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD; 
import static java.lang.annotation.ElementType.METHOD; 
import static java.lang.annotation.RetentionPolicy.RUNTIME; 
import java.lang.annotation.Documented;
import java.lang.annotation.Retention; 
import java.lang.annotation.Target; 
import javax.validation.Constraint; 
import javax.validation.Payload;
/**
 *
 * @author Džejlana Ščulić
 */
@Target( {  METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy =  ProductIdValidator.class)
@Documented
public @interface ProductId {
  String message() default"{com.et.webshop.validator.ProductId.message}";
  Class<?>[] groups() default {};
  public abstract Class<? extends Payload>[] payload() default{};
}
