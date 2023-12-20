package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    // (참고1) InMemoryHttpExchangeRepository가 구현하는 인터페이스에 들어가보면, findAll(..), add(..) 두가지만 기능을 제공한다.
    // (참고2) 구현체인 InMemoryHttpExchangeRepository에 들어가보면 capacity = 100으로 설정되어있다.
    // http 요청이 올 때 마다, 메모리에 capacity로 설정된 100개까지만 히스토리를 모은다. (최대 100개의 HTTP 요청을 제공)
    // 100개가 넘어가면 과거 것을 지우고, 새로운 것을 넣는다. (메모리가 무한하지 않으므로)
    // (참고3) 이걸 자주 사용하지는 않지만, 개발단계나 로컬에서 확인할 때 등 편리하게 사용할 수 있다.
    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
