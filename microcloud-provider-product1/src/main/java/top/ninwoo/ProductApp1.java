package top.ninwoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("top.ninwoo.mapper")
public class ProductApp1 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp1.class, args);
    }
}
