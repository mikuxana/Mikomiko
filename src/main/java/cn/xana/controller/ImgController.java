package cn.xana.controller;


import cn.xana.pojo.Img;
import cn.xana.service.ImgService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/img")
public class ImgController {

    @Autowired
    private ImgService imgService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/select")
    @ResponseBody
    public String select(Integer id, Integer hid) throws JsonProcessingException {
        List<Img> sels = imgService.select(id);
        sels.addAll(imgService.selectH(hid));
        return objectMapper.writeValueAsString(sels);
    }
}
