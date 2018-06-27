package com.github.sulne.blog.service.impl;

import com.github.sulne.blog.dao.TimeLineDao;
import com.github.sulne.blog.entity.TimeLine;
import com.github.sulne.blog.service.TimeLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("timeLineService")
public class TimeLineServiceImpl implements TimeLineService {

    @Resource
    private TimeLineDao dao;
    @Override
    public void create(TimeLine object) {
        dao.create(object);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(TimeLine object) {
        dao.update(object);
    }

    @Override
    public TimeLine get(String id) {
        return dao.get(id);
    }

    @Override
    public List<TimeLine> list() {
        return dao.list();
    }
}
