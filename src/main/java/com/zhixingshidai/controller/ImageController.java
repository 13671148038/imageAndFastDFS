package com.zhixingshidai.controller;


import com.zhixingshidai.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("getImage.do")
    @ResponseBody
    public List<Map<String,Object>> getImage(){
        List<Map<String,Object>> result = imageService.getImage();
        return result;
    }
}
