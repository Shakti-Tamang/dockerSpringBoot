package com.nextstep.docker.Reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
public class ApiResponse<T> {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("statusCode")
    private int statusCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("token")
    private String token;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("refreh_token")
    private String refresh_token;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("Data")
    private T data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("List")
    private List<T> list;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("paginate")
    private Page<T> pages;


}
