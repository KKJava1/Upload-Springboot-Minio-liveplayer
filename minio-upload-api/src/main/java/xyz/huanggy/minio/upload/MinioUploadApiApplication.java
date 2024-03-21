package xyz.huanggy.minio.upload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@MapperScan("xyz.huanggy.**.mapper")
@SpringBootApplication
public class MinioUploadApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioUploadApiApplication.class, args);
    }

}
