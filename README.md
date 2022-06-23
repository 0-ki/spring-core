# spring-core
Spring Core Study

- IntelliJ 단축키
    ㅇ Ctrl + Alt + V : new Member(1L, "member A", Grade.VIP); 에서 변수타입/변수명 자동으로 완성
    ㅇ Ctrl + Alt + M : Extract Method - 리팩토링 시, 메서드로 추출해 준다.
    ㅇ Alt + Insert   : Generate ... ( Constructor , Getter & Setter 등 )
    ㅇ F2             : 현재 파일에서 문제 있는 부분의 앞 쪽으로 커서를 이동해 준다.
    ㅇ Ctrl + Shift + Enter : ; 세미콜론을 붙여서 엔터한 효과
    ㅇ soutv          : 상단의 변수를 출력하는 Sysout을 생성한다.
    ㅇ iter           : 상단에서 반복 가능한 변수등의 구조를 찾아 for문을 만들어 준다.


- Annotaion과 Spring 기능
    ㅇ @Test         : JUnit5 프레임워크의 테스트 메서드로 지정
    ㅇ @Configuration : springframework의 Annotaion. 구성(설정) class로 등록. @Bean을 수동 등록 하는 경우 사용
    ㅇ ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // @Configuration으로 지정한 클래스를 Bean으로 컨테이너에 등록
    ㅇ  @ComponentScan: 해당 패키지를 포함한 하위의 클래스에서 bean 대상을 조회 ->
        @Component: Spring이 해당 클래스 인스턴스 생성하여 컨테이너에 등록 ->
        @Autowired: 기본적으로 Type 일치 Bean을 주입한다
        @Bean: Method에만 적용 가능하며, 해당 메서드에서 생성된 인스턴스를 (필요시 프로퍼티를 변경 등의 작업 후) 컨테이너에 등록
    ㅇ @SpringBootApplication에 @ComponentScan이 포함되어 있다.
    ㅇ @RequiredArgsConstructor : final이 붙은 필드를 생성자로 초기화 하는 메서드 자동 생성 ( 생성자 주입 )
    ㅇ @Qualifier : @Autowired 등 Bean 주입시, 타입으로 먼저 조회하는데 같은 타입이 있는 경우에 @Qualifier가 일치하는 Bean을 주입한다.
    ㅇ @Primary : @Autowired 등 Bean 주입시, 타입이 2개 이상이면 우선권을 가짐.
    ㅇ @PostConstruct @PreDestroy : 컨테이너에 빈 등록 후, 소멸 시 실행할 메서드 ( App 종료시 안전한 연결의 종료 등 )
    ㅇ ObjectProvider : DL(의존 관계조회) 정도의 기능을 위해 사용 (ObjectFactory를 상속 받아 추가 기능 등을 지원) 예시) request의 scope을 가지는 Bean을 사용시
    ㅇ @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) -> 위의 ObjectProvider를 사용해 조회하는 것처럼 Proxy객체를 사용하여 동작한다.

- Bean 관련 지식
    ㅇ Spring Bean 조회시 범위 : (Bean bean.getBeanDefinitions() ) 부모를 조회하면 자식까지 모두 조회된다. (모든 Java는 Object를 상속하므로 Object로 전체 조회 가능)
    ㅇ @ComponentScan 자동 Vs @Bean 수동 중복 등록시 : @ComponentScan에 의해 @Component로 등록한 bean과, @Bean이 적용된 메서드로 수동 등록시 수동이 Override로 적용 되지만,
        SpringBootApp 실행 시에는 충돌이 기본값
    ㅇ 수동/자동 등록 : 기술 지원 객체 등은 직접 수동 등록 (Configuration Bean)으로 관리, 다형성 적극 활용하는 비즈니스 로직은 필요시 수동 등록
    ㅇ Bean 생성/소멸시 : @Bean(initMethod = "init", destroyMethod = "close") 과 같이 메서드명 지정하여 호출. destroyMethod는 기본값이 "close","shutdown"을 추론하여 실행시키도록 되어 있다!(외부라이브러리에 사용)
    ㅇ scope ( singleton , prototype , request , session , websocket 등 )
