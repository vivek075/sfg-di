package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.services.LifeCycleDemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"guru.springframework.sfgdi"})       //This line is just for illustration purpose, to show usage of @ComponentScan annotation
@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx  = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController           = ctx.getBean(MyController.class);
        LifeCycleDemoBean lifeCycleDemoBean = (LifeCycleDemoBean) ctx.getBean("lifeCycleDemoBean");
        /*String message                      = myController.sayHello();
        System.out.println(message);*/
        System.out.println("------- I18N -------------");
        I18nController i18nController =
                (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());
        System.out.println("------ Primary -----------");
        System.out.println(myController.sayHello());
        System.out.println("------ Property ----------");
        PropertyInjectedController propertyInjectedController =
                ctx.getBean(PropertyInjectedController.class);
        System.out.println(propertyInjectedController.getGreeting());
        System.out.println("------ Setter ----------");
        SetterInjectedController setterInjectedController =
                ctx.getBean(SetterInjectedController.class);
        System.out.println(setterInjectedController.getGreeting());
        System.out.println("------Constructor-------");
        ConstructorInjectedController constructorInjectedController =
                ctx.getBean(ConstructorInjectedController.class);
        System.out.println(constructorInjectedController.getGreeting());
    }

}
