package wiki.laona.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wiki.laona.springcloud.dao.DeptDao;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.pojo.Result;
import wiki.laona.springcloud.service.IDeptService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author laona
 * @description 部门服务实现类
 * @create 2022-03-13 23:52
 **/
@Service
@Slf4j
public class DeptServiceImpl implements IDeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public Result<String> addDept(Dept dept) {
        boolean success = deptDao.addDept(dept);
        return success ? Result.SUCCESS() : Result.ERROR();
    }

    @Override
    public Result<Dept> queryById(Long id) {
        Dept dept = deptDao.queryById(id);
        return Result.SUCCESS(dept);
    }

    @Override
    public Result<List<Dept>> queryAll() {
        List<Dept> deptList = deptDao.queryAll();
        return Result.SUCCESS(deptList);
    }
}
