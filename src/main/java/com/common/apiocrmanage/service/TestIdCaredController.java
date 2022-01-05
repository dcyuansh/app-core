package com.common.apiocrmanage.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/idCared")
public class TestIdCaredController {

    @Autowired
    private ApiOcrService apiOcrService;


    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    @ResponseBody
    public Map idCard(@RequestParam("file_idcard") MultipartFile[] fileArr) throws Exception {
        MultipartFile mf1 = fileArr[0];
        MultipartFile mf2 = fileArr[1];

        //正面
        JSONObject jo_fr = apiOcrService.idCard(mf1.getBytes(), "front");
        // System.out.println("正面：" + jo_fr);

        //背面
        JSONObject jo_ba = apiOcrService.idCard(mf2.getBytes(), "back");
        //System.out.println("背面：" + jo_ba);

        Map<String,Object> map = new HashMap<>();
        map.put("front", jo_fr.toMap());
        map.put("back", jo_ba.toMap());
        //System.out.println(map.toString());
        return map;
    }

}