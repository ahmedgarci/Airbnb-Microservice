package com.AirbnbClone.PropertyService.Responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> Content;
    private Integer size;
    private Long totalElements;
    private Integer pageNumber;
    private boolean isFirst;
    private boolean isLast;
    
}
