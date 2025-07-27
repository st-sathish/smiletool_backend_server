package com.daypaytechnologies.smiletool.account.services;

import com.daypaytechnologies.smiletool.account.data.AccountData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountData fetchAccount() {
        final AccountData accountData = new AccountData();
        accountData.setFirstName("Sathish");
        accountData.setLastName("Thangathurai");
        accountData.setUserName("Hello user");
        return accountData;
    }
}
