package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("### LifeCycleBean Demo Constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("### LifeCycleBean Demo has its properties set...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("### LifeCycleBean terminated");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("### Bean name is: "+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## BeanFactory has been Set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("### ApplicationContext Set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("### PostConstruct called...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("### PreDestroy called...");
    }
}
