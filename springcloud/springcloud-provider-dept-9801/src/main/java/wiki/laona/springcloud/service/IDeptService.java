package wiki.laona.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.pojo.Result;

import java.util.List;

/**
 * @author laona
 * @description 部门 service 接口
 * @create 2022-03-13 23:49
 **/
public interface IDeptService {

    /**
     * 添加一个部门
     * @param dept {@see Dept} 部门实体
     * @return 成功 -> true, 失败 -> false
     */
    Result<String> addDept(Dept dept);

    /**
     * 通过部门 ID 查询部门信息
     * @param id 部门 ID
     * @return dept {@see Dept} 部门信息
     */
    Result<Dept> queryById(Long id);

    /**
     * 查询所有部门信息
     * @return dept {@see Dept} 所有部门信息
     */
    Result<List<Dept>> queryAll();
}
