package cn.xana.controller;

import cn.xana.pojo.ACGRec;
import cn.xana.service.ACGService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/acg")
public class ACGController {
    @Autowired
    private ACGService acgService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/query/bangumi")
    @ResponseBody
    public String select0() throws JsonProcessingException {
        List<ACGRec> res = acgService.selectBangumi(30);
        return objectMapper.writeValueAsString(res);
    }
    @GetMapping("/query/game")
    @ResponseBody
    public String select1() throws JsonProcessingException {
        List<ACGRec> res = acgService.selectGame(30);
        return objectMapper.writeValueAsString(res);
    }
}
