package com.studia.to.connection;

import java.util.List;

public class Server {
    private List<Client> clientList;

    public void addClient(Client client){
        clientList.add(client);
    }

    public void removeClient(Client client){
        clientList.remove(client);
    }
}
