package com.example.demo;

import com.example.demo.domain.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//    @Configuration 클래스가 필요한 경우
//    1. 외부 라이브러리 객체를 빈으로 등록해야 할 때
//    -> @Component X => Configuration + @Bean 사용
//    2. 복잡한 의존성 조합을 수동으로 설정할 때
//    -> 단순한 서비스 -> 리포지 1개 의존성 주입 but
//    -> 복잡한 조합 => service/repository/외부 빈을 합쳐서 새로운 빈 생성
//    3. 환경별/ 프로파일별 설정
//    -> 개발("dev") / 테스트("test")/ 운영("prod") 환경마다 다른 객체를 주입할 때
//    -> @Profile을 붙여서 구현
//    4. AOP, 트랜잭션, 시큐리티, 커스텀 설정
}
