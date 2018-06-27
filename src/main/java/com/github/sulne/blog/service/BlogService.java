package com.github.sulne.blog.service;

import com.github.sulne.blog.entity.Blog;

public interface BlogService extends BaseService<Blog> {
    Blog find(Integer no);
}
