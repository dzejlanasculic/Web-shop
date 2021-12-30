/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.dao;

import com.et.webshop.domain.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Džejlana Ščulić
 */
public class ProductDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Product p){    
    String sql="insert into product(idproduct, name, unitPrice, description, manufacturer, category, unitsInStock, unitsInOrder, discontinued, condition) values('"+p.getProductId()+"','"+p.getName()+"',"+p.getUnitPrice()+",'"+p.getDescription()+"', '"+p.getManufacturer()+"', '"+p.getCategory()+"', '"+p.getUnitsInStock()+"', '"+p.getUnitsInOrder()+"', '"+p.isDiscontinued()+"', '"+p.getCondition()+"')";    
    return template.update(sql);    
}    
public int update(Product p){    
    String sql="update product set name='"+p.getName()+"', unitPrice="+p.getUnitPrice()+",description='"+p.getDescription()+"', manufacturer='"+p.getManufacturer()+"', category='"+p.getCategory()+"', unitsInStock='"+p.getUnitsInStock()+"', unitsInOrder='"+p.getUnitsInOrder()+"',discontinued= '"+p.isDiscontinued()+"', condition='"+p.getCondition()+"' where id="+p.getProductId()+"";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from product where id="+id+"";    
    return template.update(sql);    
}    
public Product getProductById(int id){    
    String sql="select * from product where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));    
}    
public List<Product> getProducts(){    
    return template.query("select * from product",new RowMapper<Product>(){    
        public Product mapRow(ResultSet rs, int row) throws SQLException {    
            Product p =new Product();    
            p.setProductId(rs.getString(1));    
            p.setName(rs.getString(2));    
            p.setUnitPrice(rs.getBigDecimal(3));    
            p.setDescription(rs.getString(4)); 
            p.setManufacturer(rs.getString(5)); 
            p.setCategory(rs.getString(6));
            p.setUnitsInStock(rs.getLong(7));
            p.setUnitsInOrder(rs.getLong(8));
            p.setDiscontinued(rs.getBoolean(9));
            p.setCondition(rs.getString(10)); 
            return p;    
        }    
    });    
}    
}
