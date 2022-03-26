package wiki.laona.springcloud.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.pojo.Result;
import wiki.laona.springcloud.service.IDeptService;

import java.util.List;

/**
 * @author laona
 * @description 部门控制器
 * @date 2022-03-26 14:32
 **/
@RestController
@RequestMapping("/dept/")
public class DeptController {

    private final IDeptService deptService;

    public DeptController(IDeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping("/add")
    public Result<String> addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Result<Dept> getDept(@PathVariable Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/list")
    public Result<List<Dept>> addDept() {
        return deptService.queryAll();
    }
}
