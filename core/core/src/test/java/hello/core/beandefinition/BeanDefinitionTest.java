package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBena(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames)
        {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//            System.out.println(ac.getBean(beanDefinitionName));
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
            {
                System.out.println("beanDefintionName = " + beanDefinitionName + " beandefinition" + beanDefinition);
            }
        }
    }

}
