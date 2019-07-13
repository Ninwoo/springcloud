package top.ninwoo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.ninwoo.vo.Product;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
    public static final String PRODUCT_GET_URL = "http://microcloud-provider-product/product/get/";
    public static final String PRODUCT_LIST_URL = "http://microcloud-provider-product/product/list/";
    public static final String PRODUCT_ADD_URL = "http://microcloud-provider-product/product/add/";

    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id,
                HttpMethod.GET,new HttpEntity<Object>(httpHeaders),Product.class).getBody();
        return product;
    }

    @RequestMapping("/product/list")
    public Object listProduct() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microcloud-provider-product");
        System.out.println("[**** ServiceInstance ***]host = " + serviceInstance.getHost() +
                "、port = " + serviceInstance.getPort());
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,
                HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addProduct(Product product) {
        return restTemplate.exchange(PRODUCT_ADD_URL,HttpMethod.POST,
                new HttpEntity<>(product, httpHeaders), Boolean.class).getBody();
    }

}
