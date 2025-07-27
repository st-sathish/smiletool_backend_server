package com.daypaytechnologies.smiletool.executions.rmi;

import com.daypaytechnologies.smiletool.core.annotations.RmiService;
import com.daypaytechnologies.smiletool.core.rmi.BaseRmiRemote;
import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.rmi.RemoteException;

@Service
@Slf4j
@RmiService("RestRmiExecutorService")
public class RestRmiExecutorServiceImpl extends BaseRmiRemote implements RestRmiExecutorService {

    private final RestTemplate restTemplate;

    public RestRmiExecutorServiceImpl(RestTemplate restTemplate) throws RemoteException {
        super();
        this.restTemplate = restTemplate;
    }

    @Override
    public String execute(RestRequestDTO restRequestDTO) throws RemoteException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        if("POST".equals(restRequestDTO.getHttpMethod())) {
            requestEntity = new HttpEntity<>(requestEntity.getBody(), headers);
        }
        try {
            HttpMethod httpMethod = HttpMethod.valueOf(restRequestDTO.getHttpMethod());
            ResponseEntity<String> response = restTemplate.exchange(
                    restRequestDTO.getRestURL(),
                    httpMethod,
                    requestEntity,
                    String.class
            );
            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
            return responseBody;
        } catch (Exception e) {
            throw e;
        }
    }
}
