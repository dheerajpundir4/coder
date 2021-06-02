package com.qwetzal.coder.service;

import com.qwetzal.coder.entities.Tag;
import com.qwetzal.coder.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag getTag(Long id) {

        Optional<Tag> opt=this.tagRepository.findById(id);
        return opt.get();
    }

    public Tag addTag(Tag tag) {
        tag.setCreatedAt(LocalDateTime.now());
        return this.tagRepository.save(tag);
    }


    public Tag updateTag(Tag tag) {

        Tag tagPresent=tagRepository.getOne(Long.parseLong(tag.getId().toString()));
            tagPresent.setName(tag.getName());
            tagPresent.setUpdatedAt(LocalDateTime.now());
        return this.tagRepository.save(tagPresent);
    }

    public void deleteTags(Long id){

        Tag tag=tagRepository.getOne(id);
        tag.setDeletedAt(LocalDateTime.now());
        tagRepository.save(tag);

    }
}
