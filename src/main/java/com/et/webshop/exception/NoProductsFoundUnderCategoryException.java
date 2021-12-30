/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *
 * @author Džejlana Ščulić
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Nema pronađenih proizvoda pod ovom kategorijom.")
public class NoProductsFoundUnderCategoryException extends RuntimeException{
    private static final long serialVersionUID =3935230281455340039L;
}
