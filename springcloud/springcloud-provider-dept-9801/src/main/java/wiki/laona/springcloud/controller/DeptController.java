package wiki.laona.springcloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.pojo.Result;
import wiki.laona.springcloud.service.IDeptService;

import java.util.List;

/**
 * @author laona
 * @description 部门控制器
 * 提供  restful 服务
 * @date 2022-03-26 14:32
 **/
@RestController
@RequestMapping("/dept/")
public class DeptController {

    private final IDeptService deptService;
    /**
     * 微服务配置信息获取客户端
     */
    private final DiscoveryClient client;

    public DeptController(IDeptService deptService, DiscoveryClient client) {
        this.deptService = deptService;
        this.client = client;
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

    @GetMapping("/discovery")
    public Object discovery() {
        // 微服务的清单
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println("instance = " + instance);
        }
        return this.client;
    }
}
