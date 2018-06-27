package com.github.sulne.blog.service.impl;

import com.github.sulne.blog.dao.WebLogDao;
import com.github.sulne.blog.entity.WebLog;
import com.github.sulne.blog.service.WebLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("webLogService")
public class WebLogServiceImpl implements WebLogService{
    @Resource
    private WebLogDao dao;

    @Override
    public void create(WebLog object) {
        dao.create(object);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(WebLog object) {
        dao.update(object);
    }

    @Override
    public WebLog get(String id) {
        return dao.get(id);
    }

    @Override
    public List<WebLog> list() {
        return dao.list();
    }
}
