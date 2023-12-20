package com.ermeson.crudspring.dto;

import java.util.List;

public record CoursePageDTO(List<CourseDTO> courses, long totalElement, int totalPages) {
    
}
