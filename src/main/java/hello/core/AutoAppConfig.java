package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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

    // 수동으로 등록한 빈이 자동보다 우선권을 가진다.(오버라이딩) -> 잡기 애매한 버그가 발생할 위험이 있다. -> 스프링부트 실행 시 오류가 발생됨
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
