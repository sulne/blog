package com.github.sulne.blog.controller;

import com.github.sulne.blog.entity.Blog;
import com.github.sulne.blog.service.BlogService;
import com.github.sulne.blog.tool.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping({"/{no}"})
    public ResponseEntity<Blog> get(@PathVariable Integer no) {
        try {
            Blog blog = this.blogService.find(no);
            if (null == blog) {
                // 资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(blog);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = {"/{no}"},produces = "text/html")
    public ModelAndView find(@PathVariable Integer no) {
        System.out.println(no);
        ModelAndView mav = new ModelAndView("/blog");

        return mav;
    }

    @GetMapping({""})
    public ResponseEntity<List<Blog>> blog() {
        return ResponseEntity.ok(this.blogService.list());
    }

    @PostMapping
    public ResponseEntity<Void> save(Blog blog) {
        try {
            blog.setDate(MyTool.date());
            this.blogService.create(blog);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception var3) {
            var3.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping({"/upload"})
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        String filePath = request.getSession().getServletContext().getRealPath("/upload/blog");

        try {
            MyTool.uploadFile(file.getBytes(), filePath, fileName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception var7) {
            var7.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> edit(@PathVariable String id, Blog blog) {
        try {
            blog.setId(id);
            this.blogService.update(blog);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            this.blogService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception var3) {
            var3.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
