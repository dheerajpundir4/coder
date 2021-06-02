package com.qwetzal.coder.controller;

import com.qwetzal.coder.dto.ResourceRequest;
import com.qwetzal.coder.dto.ResourceResponse;
import com.qwetzal.coder.entities.Resource;
import com.qwetzal.coder.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping("/resources")
    public List<ResourceResponse> index() {
        return resourceService.getAllResources();
    }

    @PostMapping("/resources")
    public Resource store(@Valid @RequestBody ResourceRequest resourceRequest) {
        return resourceService.addResource(resourceRequest);
    }

    @GetMapping("resources/{id)")
    public Resource show(@PathVariable Long id) {
        return resourceService.getResource(id);
    }


    @PutMapping("/resources/{id}")
    public Resource update(@RequestBody Resource resource, @PathVariable Long id) {
        return resourceService.updateResource(resource, id);
    }

    @DeleteMapping("/resources/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);

    }
}
