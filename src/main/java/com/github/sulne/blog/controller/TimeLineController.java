package com.github.sulne.blog.controller;

import com.github.sulne.blog.entity.TimeLine;
import com.github.sulne.blog.service.TimeLineService;
import com.github.sulne.blog.tool.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeLine")
public class TimeLineController {

    @Autowired
    private TimeLineService service;

    @GetMapping("/{id}")
    public ResponseEntity<TimeLine> get(@PathVariable String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping()
    public void save(TimeLine timeLine) {
        timeLine.setId(MyTool.UUID());
        service.create(timeLine);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable String id,TimeLine timeLine) {
        timeLine.setId(id);
        service.update(timeLine);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping()
    public ResponseEntity<List<TimeLine>> list() {
        return ResponseEntity.ok(service.list());
    }
}
