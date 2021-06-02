package com.qwetzal.coder.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id){
        super("Resource not found id: " + id);
    }
}
