package wiki.laona.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wiki.laona.springcloud.constant.CommonConstant;
import wiki.laona.springcloud.constant.Constant;
import wiki.laona.springcloud.pojo.Dept;
import wiki.laona.springcloud.pojo.Result;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author laona
 * @description dept消费者
 * @create 2022-03-26 21:32
 **/
@RestController
@RequestMapping("/consumer/dept/")
public class DeptController {

    private final RestTemplate restTemplate;

    public DeptController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("add")
    public Result<String> add(@RequestBody Dept dept) {
        String url = Constant.REST_PREFIX + "add";
        return restTemplate.postForObject(url, dept, Result.class);
    }

    @GetMapping("get/{id}")
    public Result<Dept> get(@PathVariable("id") Long id){
        String url = Constant.REST_PREFIX  + "get/{id}";
        HashMap<String, Long> uriVariables = new HashMap<>(CommonConstant.MAP_INIT_CAPACITY);
        uriVariables.put("id", id);
        return restTemplate.getForObject(url, Result.class, uriVariables);
    }

    @GetMapping("list")
    public Result<List<Dept>> list(){
        String url = Constant.REST_PREFIX  + "list";
        return restTemplate.getForObject(url, Result.class, Collections.emptyMap());
    }
}
