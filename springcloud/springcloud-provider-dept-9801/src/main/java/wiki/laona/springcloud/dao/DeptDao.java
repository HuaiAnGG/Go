package wiki.laona.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wiki.laona.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author laona
 * @description 部门
 * @create 2022-03-13 23:38
 **/
@Mapper
public interface DeptDao {

    /**
     * 添加一个部门
     * @param dept {@see Dept} 部门实体
     * @return 成功 -> true, 失败 -> false
     */
    boolean addDept(@Param("param") Dept dept);

    /**
     * 通过部门 ID 查询部门信息
     * @param id 部门 ID
     * @return dept {@see Dept} 部门信息
     */
    Dept queryById(Long id);

    /**
     * 查询所有部门信息
     * @return dept {@see Dept} 所有部门信息
     */
    List<Dept> queryAll();
}
