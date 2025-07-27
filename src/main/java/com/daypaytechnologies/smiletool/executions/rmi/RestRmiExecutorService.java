package com.daypaytechnologies.smiletool.executions.rmi;

import com.daypaytechnologies.smiletool.core.rmi.RmiRemote;
import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;

import java.rmi.RemoteException;

public interface RestRmiExecutorService extends RmiRemote {

    String execute(RestRequestDTO restRequestDTO) throws RemoteException;
}
