/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.controller;
import com.et.webshop.domain.Cart;
import com.et.webshop.domain.CartItem;
import com.et.webshop.domain.Product;
import com.et.webshop.exception.ProductNotFoundException;
import com.et.webshop.service.CartService;
import com.et.webshop.service.ProductService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *
 * @author Džejlana Ščulić
 */
@Controller
@RequestMapping(value =  "rest/cart")
public class CartRestController {
  private CartService cartService;
  private ProductService productService;
  
  @RequestMapping(method =  RequestMethod.POST)
  public @ResponseBody Cart create(@RequestBody Cart cart) {
    return  cartService.create(cart);
  }

  @RequestMapping(value =  "/{cartId}", method =  RequestMethod.GET)
  public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
    return cartService.read(cartId);
  }

  @RequestMapping(value =  "/{cartId}", method =  RequestMethod.PUT)
  @ResponseStatus(value =  HttpStatus.NO_CONTENT)
  public void update(@PathVariable(value = "cartId") String cartId,  @RequestBody Cart cart) {
    cartService.update(cartId, cart);
  }

  @RequestMapping(value =  "/{cartId}", method =  RequestMethod.DELETE)
  @ResponseStatus(value =  HttpStatus.NO_CONTENT)
  public void delete(@PathVariable(value =  "cartId") String cartId) {
    cartService.delete(cartId);
  }

  
  @RequestMapping(value =  "/add/{productId}", method = RequestMethod.PUT)
  @ResponseStatus(value =  HttpStatus.NO_CONTENT)
  public void addItem(@PathVariable String productId, HttpServletRequest request) {

    
    String sessionId =  request.getSession(true).getId();
    Cart cart =  cartService.read(sessionId);
    if(cart== null) {
      cart =  cartService.create(new Cart(sessionId));
    }

    
    Product product =  productService.getProductById(productId);
    if(product ==  null) {
      throw new IllegalArgumentException(new ProductNotFoundException(productId));
    }
    cart.addCartItem(new CartItem(product));  
    cartService.update(sessionId, cart);
  }

  
  @RequestMapping(value =  "/remove/{productId}", method = RequestMethod.PUT)
  @ResponseStatus(value =  HttpStatus.NO_CONTENT)
  public void removeItem(@PathVariable String productId, HttpServletRequest request) {

    
    String sessionId =  request.getSession(true).getId();
    Cart cart =  cartService.read(sessionId);
    if(cart== null) {
      cart =  cartService.create(new Cart(sessionId));
    }

    
    Product product =  productService.getProductById(productId);
    if(product ==  null) {
      throw new IllegalArgumentException(new ProductNotFoundException(productId));
    }
    
    cart.removeCartItem(new CartItem(product));    
    cartService.update(sessionId, cart);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason="Neispravan zahtjev!")
  public void handleClientErrors(Exception ex) {  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Greška na serveru!")
  public void handleServerErrors(Exception ex) {}
}
