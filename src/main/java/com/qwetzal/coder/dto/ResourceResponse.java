package com.qwetzal.coder.dto;

import com.qwetzal.coder.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ResourceResponse {
    private String title;
    private String description;
    private String type;
    private String visibility;
    private String category;
    private User user;
}
