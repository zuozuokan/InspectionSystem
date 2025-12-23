package org.example.inspectionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@MapperScan("org.example.inspectionsystem.mapper")
public class InspectionSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(InspectionSystemApplication.class, args);
    }
}
