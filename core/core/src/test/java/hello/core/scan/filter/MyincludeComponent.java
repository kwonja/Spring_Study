package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyincludeComponent { //컴포넌트를 추가할것이라고 이해하면된다.

}

