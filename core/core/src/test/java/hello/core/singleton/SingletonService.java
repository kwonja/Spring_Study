package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //static 변수로 선언하기때문에 객체를 공유할 수 있음
    @Test
    public static SingletonService getInstance()
    {
        return instance;
    }

    private SingletonService() { //private으로 설정하여 외부에서 객체를 선언하는것을 막는다
        System.out.println("생성자 호출");
    }
    public void logic()
    {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
