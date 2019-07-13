package top.ninwoo.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ninwoo.service.IProductService;
import top.ninwoo.vo.Product;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private IProductService iProductService;

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id);
    }

    @RequestMapping("/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product);
    }

    @RequestMapping("/list")
    public Object list() {
        return this.iProductService.list();
    }

    @RequestMapping("/discover")
    public Object discover() {
        return this.client;
    }
}
