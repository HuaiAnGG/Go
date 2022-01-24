package wiki.laona.obj;

import java.io.Serializable;

/**
 * @author laona
 * @description
 * @date 2022-01-22 17:34
 **/
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * transient 表示游离，不参与序列化
     */
    private transient String no;
    private String name;

    public Students() {
    }

    public Students(String no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
