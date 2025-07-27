package com.daypaytechnologies.smiletool.core.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class BaseRmiRemote extends UnicastRemoteObject {

    protected BaseRmiRemote() throws RemoteException {
        super();
    }

    protected BaseRmiRemote(int port) throws RemoteException {
        super(port);
    }

    protected BaseRmiRemote(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }
}
