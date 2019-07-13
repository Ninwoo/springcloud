package top.ninwoo.mapper;

import top.ninwoo.vo.Product;

import java.util.List;

public interface ProductMapper {
    boolean create(Product product);
    Product findById(Long id);
    List<Product> findAll();
}
