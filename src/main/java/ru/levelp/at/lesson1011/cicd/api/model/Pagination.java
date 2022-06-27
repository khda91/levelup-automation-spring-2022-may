package ru.levelp.at.lesson1011.cicd.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Integer limit;
    private Integer offset;
    private Integer totalCount;
}
