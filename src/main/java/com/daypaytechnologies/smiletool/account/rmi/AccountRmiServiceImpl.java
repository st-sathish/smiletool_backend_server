package com.daypaytechnologies.smiletool.account.rmi;

import com.daypaytechnologies.smiletool.core.annotations.RmiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RmiService("AccountRmiService")
public class AccountRmiServiceImpl implements AccountRmiService {
}
