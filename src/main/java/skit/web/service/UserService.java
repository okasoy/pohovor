package skit.web.service;

import skit.web.entity.Account;

public interface UserService {
    void addUser(Account user);
    void payForDisk(String username,int payment);
}
