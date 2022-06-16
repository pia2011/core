package study.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 속도 향상을 위해서, 여러 패키지를 전부 뒤지면 시간이 오래걸림. 특정 패키지 하위만 뒤지도록 하면 속도 향상
        // default : 여기 설정 클래스가 속한 패키지의 하위 (study.spring.core) - 권장
        basePackages = "study.spring.core",
        // 기존 예제 코드 유지하기 위해서..
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
