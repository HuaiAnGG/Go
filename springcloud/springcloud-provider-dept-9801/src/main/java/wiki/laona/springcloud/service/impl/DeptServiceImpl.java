package wiki.laona.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wiki.laona.springcloud.dao.DeptDao;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.service.IDeptService;

import java.util.List;

/**
 * @author laona
 * @description 部门服务实现类
 * @create 2022-03-13 23:52
 **/
@Service
@Slf4j
public class DeptServiceImpl implements IDeptService {

    private final DeptDao deptDao;

    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
