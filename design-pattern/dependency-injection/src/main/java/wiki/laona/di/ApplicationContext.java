package wiki.laona.di;

/**
 * @author laona
 * @description applicationContext
 * @create 2022-01-03 12:47
 **/
public interface ApplicationContext {
    /**
     * 获取 bean
     *
     * @param beanId bean id
     * @return Object
     */
    Object getBean(String beanId);
}
