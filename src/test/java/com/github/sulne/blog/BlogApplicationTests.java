package com.github.sulne.blog;

import com.github.sulne.blog.entity.Blog;
import com.github.sulne.blog.service.BlogService;
import com.github.sulne.blog.tool.MyTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.github.sulne.blog.dao")
public class BlogApplicationTests {

	@Autowired
	private BlogService blogService;

	@Test
	public void contextLoads() {
		Blog blog = new Blog();
		blog.setNo(1);
		blog.setId(MyTool.UUID());
		blog.setDate(MyTool.date());
		blog.setTitle("第一篇博客");
		blog.setContent("写点什么吧");
		blogService.create(blog);
	}

}
