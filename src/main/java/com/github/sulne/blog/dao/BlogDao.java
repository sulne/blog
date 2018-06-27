package com.github.sulne.blog.dao;

import com.github.sulne.blog.entity.Blog;

public interface BlogDao extends BaseDao<Blog>{
    Blog find(Integer no);
}
