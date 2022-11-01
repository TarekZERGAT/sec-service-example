package com.ztardz.secservice.sec.services;

import com.ztardz.secservice.sec.entities.AppRole;
import com.ztardz.secservice.sec.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
