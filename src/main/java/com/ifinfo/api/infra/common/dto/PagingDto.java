package com.ifinfo.api.infra.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PagingDto {

    private Integer pageIndex;
    private Integer pageRow;
    private List<String> sort;
}
