package wiki.laona.di;

import lombok.Data;

/**
 * @author laona
 * @description
 * @create 2022-01-03 14:18
 **/
@Data
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;
}
