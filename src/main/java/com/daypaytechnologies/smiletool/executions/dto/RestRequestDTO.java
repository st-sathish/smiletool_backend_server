package com.daypaytechnologies.smiletool.executions.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestRequestDTO implements Serializable {

    private String httpMethod;

    private String restURL;

    private String requestBody;
}
