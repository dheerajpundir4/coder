package com.qwetzal.coder.service.impl;

import com.qwetzal.coder.dto.ResourceRequest;
import com.qwetzal.coder.dto.ResourceResponse;
import com.qwetzal.coder.entities.Resource;
import com.qwetzal.coder.entities.User;
import com.qwetzal.coder.exceptions.ResourceNotFoundException;
import com.qwetzal.coder.repositories.ResourceRepository;
import com.qwetzal.coder.repositories.UserRepository;
import com.qwetzal.coder.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ResourceResponse> getAllResources() {
        List<Resource> resourceList = resourceRepository.findAllByDeletedAtNull();

        Map<Long, User> users = resourceList.stream()
                .map(Resource::getUserId)
                .map(id -> userRepository.findById(id).get())
                .collect(Collectors.toMap(User::getId, u -> u));

        return resourceList.stream().map(res -> {
                    ResourceResponse response = new ResourceResponse()
                            .setTitle(res.getTitle())
                            .setDescription(res.getDescription())
                            .setType(res.getType())
                            .setVisibility(res.getVisibility())
                            .setCategory(res.getCategory());

                    if (users.containsKey(res.getUserId())) {
                        response.setUser(users.get(res.getUserId()));
                    } else {
                        response.setUser(null);
                    }

                    return response;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Resource addResource(ResourceRequest resourceRequest) {

        Resource resource = new Resource().setTitle(resourceRequest.getTitle())
                .setDescription(resourceRequest.getDescription())
                .setType(resourceRequest.getType())
                .setUserId(1l)
                .setVisibility(resourceRequest.getVisibility())
                .setCategory(resourceRequest.getCategory());

        return resourceRepository.save(resource);
    }

    @Override
    public Resource updateResource(Resource resource, Long id) {
        return resourceRepository.findById(id)
                .map(res -> {
                    res.setTitle(resource.getTitle())
                            .setDescription(resource.getDescription());

                    return resourceRepository.save(res);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void deleteResource(Long id) {
        Resource resource = resourceRepository.getOne(id);
        resource.setDeletedAt(LocalDateTime.now());
        resourceRepository.save(resource);
    }
}
