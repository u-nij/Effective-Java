package me.whiteship.chapter01.item01;

import me.whiteship.hello.ChineseHelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 서비스 제공자 등록 API
public class AppConfig {

    @Bean
    public HelloService helloService() {
        return new ChineseHelloService();
    }

}
