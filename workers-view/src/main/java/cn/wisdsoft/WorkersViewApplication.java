package cn.wisdsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkersViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkersViewApplication.class, args);
    }

}
