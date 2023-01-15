package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Compoent 를 통해 빈에 등록을 해도 되지만 정형화된게 아니라서 bean으로 등록했다는걸 알려도 좋음
@Aspect //AOP를 사용하기위해 선언
//@Component //직접 Bean으로 등록하려고하면 제거해줘야한다.
public class TimeTraceAop { //SPRING에 등록해줘야함

    @Around("execution(* hello.hellospring.service..*(..)) && !target(hello.hellospring.SpringConfig)")
    //어디에 AOP를 타켓팅할건지 주소를 나타냄(패키지 하위에 있는 메소드 다 적용)
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
//            Object result =joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
