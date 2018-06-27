package com.github.sulne.blog.service.impl;

import com.github.sulne.blog.dao.BlogDao;
import com.github.sulne.blog.entity.Blog;
import com.github.sulne.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("blogService")
public class BlogServiceImpl implements BlogService{

    @Resource
    private BlogDao blogDao;

    @Override
    public Blog find(Integer no) {
        return blogDao.find(no);
    }

    @Override
    public void create(Blog object) {
        blogDao.create(object);
    }

    @Override
    public void delete(String id) {
        blogDao.delete(id);
    }

    @Override
    public void update(Blog object) {
        blogDao.update(object);
    }

    @Override
    public Blog get(String id) {
        return blogDao.get(id);
    }

    @Override
    public List<Blog> list() {
        return blogDao.list();
    }
}
