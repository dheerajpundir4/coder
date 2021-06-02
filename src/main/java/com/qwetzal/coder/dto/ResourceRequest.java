package com.qwetzal.coder.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ResourceRequest {
    @NotBlank(message = "You need to enter a title")
    private String title;

    @NotBlank(message = "Description cant be empty")
    @Size(min = 5, max = 100, message = "Length should be in between 5 -100")
    private String description;

    @NotBlank(message = "Enter type")
    private String type;

    @NotBlank(message = "Enter visiblity")
    private String visibility;

    @NotBlank(message = "Category can't be emtpy")
    private String category;
}
