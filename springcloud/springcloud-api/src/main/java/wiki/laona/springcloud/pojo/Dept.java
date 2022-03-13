package wiki.laona.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author laona
 * @description 部门
 * @create 2022-03-13 23:06
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private static final long serialVersionUID = Integer.MAX_VALUE;

    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 存在不同的数据库
     */
    private String dbSource;

    public Dept(String dbSource) {
        this.dbSource = dbSource;
    }
}
