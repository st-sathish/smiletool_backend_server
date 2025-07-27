package com.daypaytechnologies.smiletool.core.services;

import com.daypaytechnologies.smiletool.core.annotations.RmiService;
import com.daypaytechnologies.smiletool.executions.rmi.RestRmiExecutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class RmiAutoExporterService implements InitializingBean {

    private final ListableBeanFactory beanFactory;

    @Value("${com.daypaytechnologies.smile-tool.rmi-port:1099}")
    private String RMI_PORT;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> rmiBeans = beanFactory.getBeansWithAnnotation(RmiService.class);
        Registry registry = LocateRegistry.createRegistry(Integer.valueOf(RMI_PORT));
        for (Map.Entry<String, Object> entry : rmiBeans.entrySet()) {
            Remote bean = (Remote) entry.getValue();
            Class<?> clazz = bean.getClass();
            RmiService annotation = clazz.getAnnotation(RmiService.class);
            String serviceName = annotation.value();
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length == 0) {
                System.err.println("No interface found for RMI service: " + clazz.getName());
                continue;
            }
            try {
                registry.rebind(serviceName, bean);
                log.info("RMI service registered {} ",serviceName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
