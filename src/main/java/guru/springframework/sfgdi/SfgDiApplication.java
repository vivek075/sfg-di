package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.LifeCycleDemoBean;
import guru.springframework.sfgdi.services.PropertyGreetingService;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"guru.springframework.sfgdi","com.springframework.pets"})       //This line is just for illustration purpose, to show usage of @ComponentScan annotation
@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx  = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController           = ctx.getBean(MyController.class);
        LifeCycleDemoBean lifeCycleDemoBean = (LifeCycleDemoBean) ctx.getBean("lifeCycleDemoBean");
        /*String message                      = myController.sayHello();
        System.out.println(message);*/
        System.out.println("------- Pet Controller -----");
        PetController petController = ctx.getBean(PetController.class);
        System.out.println(petController.whichPetIsTheBest());
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

        System.out.println("----- Bean Scopes ------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        System.out.println(singletonBean2.getMyScope());
        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("----- Fake Datasource ------");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

    }

}
