package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx  = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController           = ctx.getBean(MyController.class);
        /*String message                      = myController.sayHello();
        System.out.println(message);*/
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
