package top.ninwoo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ninwoo.ProductApp2;
import top.ninwoo.mapper.ProductMapper;
import top.ninwoo.vo.Product;

import javax.annotation.Resource;

@SpringBootTest(classes = ProductApp2.class)
@RunWith(SpringRunner.class)
public class TestProductMapper {

    @Resource
    ProductMapper productMapper;

    @Test
    public void testProductMapper() {
        Product product = new Product();
        product.setProductDesc("这是一个测试类");
        product.setProductName("joliu");

        Assert.assertTrue(productMapper.create(product));
    }

}
