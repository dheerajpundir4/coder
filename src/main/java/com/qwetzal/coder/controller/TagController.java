package com.qwetzal.coder.controller;

import com.qwetzal.coder.entities.Tag;
import com.qwetzal.coder.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public List<Tag> index() {
        return this.tagService.getTags();
    }

    @PostMapping("/tags")
    public Tag store(@RequestBody Tag tag) {
        tag.setId(0L);
        return this.tagService.addTag(tag);
    }

    @GetMapping("tags/{tagsId}")
    public Tag show(@PathVariable String tagsId) {
        return this.tagService.getTag(Long.parseLong(tagsId));
    }


    @PutMapping("/tags")
    public Tag update(@RequestBody Tag tag) {
        return this.tagService.updateTag(tag);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        tagService.deleteTags(id);
        return new ResponseEntity<>("Tag deleted Successfully", HttpStatus.OK);

    }


}
