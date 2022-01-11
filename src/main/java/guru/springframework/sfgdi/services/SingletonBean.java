package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Singleton Bean Constructor..");
    }
    public String getMyScope() {
        return "I'm Singleton..";
    }
}
