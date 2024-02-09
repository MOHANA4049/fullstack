package com.jobapp.mona.dto.response;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Basicresponse<T> {
    private String message;
    @Builder.Default
    private List<T> data = Collections.emptyList();

}