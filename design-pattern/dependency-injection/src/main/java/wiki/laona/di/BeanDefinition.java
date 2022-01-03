package wiki.laona.di;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laona
 * @description
 * @create 2022-01-03 14:08
 **/
@Data
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs  = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return this.scope == Scope.SINGLETON;
    }
}
