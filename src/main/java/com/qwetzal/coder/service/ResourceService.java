package com.qwetzal.coder.service;

import com.qwetzal.coder.dto.ResourceRequest;
import com.qwetzal.coder.dto.ResourceResponse;
import com.qwetzal.coder.entities.Resource;

import java.util.List;

public interface ResourceService {

    List<ResourceResponse> getAllResources();

    Resource getResource(Long id);

    Resource addResource(ResourceRequest resourceRequest);

    Resource updateResource(Resource resource, Long id);

    void deleteResource(Long id);

}
