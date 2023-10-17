package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 스캔 패키지의 시작 위치 지정 -> 없으면 이 클래스를 포함한 하위 클래스들을 모두 탐색 -> 지정하지 않는 것을 권장
        basePackages = "hello.core.member",
        // 스캔 대상에서 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
