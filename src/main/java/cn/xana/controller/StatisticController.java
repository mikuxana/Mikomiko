package cn.xana.controller;


import cn.xana.pojo.Statistic;
import cn.xana.service.StatisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/query/{aid}")
    public String query(@PathVariable String aid) throws JsonProcessingException {
        Statistic statistic = statisticService.selectByid(aid);
        return objectMapper.writeValueAsString(statistic);
    }

    @PostMapping("/{field}/{aid}/{val}")
    public Integer update(@PathVariable String field, @PathVariable String aid, @PathVariable String val){
        Integer integer = statisticService.updateByFieldWithId(field, aid, val);
        return integer;
    }
    @PostMapping("/insert/{aid}")
    public Integer insert(@PathVariable String aid){
        return statisticService.insert(aid);
    }
}
