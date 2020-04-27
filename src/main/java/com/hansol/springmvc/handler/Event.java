package com.hansol.springmvc.handler;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

//    interface ValidateLimit {}
//    interface ValidateName {}

    private Long id;

//    @NotBlank(groups = ValidateName.class)
    @NotBlank
    private String name;

//    @Min(value = 0, groups = ValidateLimit.class)
    @Min(0)
    private Integer limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
