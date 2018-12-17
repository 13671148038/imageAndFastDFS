package com.zhixingshidai.service.impl;

import com.zhixingshidai.dao.ImageDao;
import com.zhixingshidai.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;
    @Override
    public List<Map<String, Object>> getImage() {
        List<Map<String, Object>> result = imageDao.getImage();
        return result;
    }
}
