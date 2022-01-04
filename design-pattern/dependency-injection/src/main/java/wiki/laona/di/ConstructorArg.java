package wiki.laona.di;

import lombok.Data;

import java.io.Serializable;

/**
 * @author laona
 * @description
 * @create 2022-01-03 14:18
 **/
@Data
public class ConstructorArg implements Serializable {
    private static final long serialVersionUID = Integer.MAX_VALUE;
    private boolean ref;
    private Class<?> type;
    private Object arg;
}
