package com.ztardz.secservice.sec.services;

import com.ztardz.secservice.sec.entities.AppRole;
import com.ztardz.secservice.sec.entities.AppUser;
import com.ztardz.secservice.sec.repositories.AppRoleRepository;
import com.ztardz.secservice.sec.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;

    private AppRoleRepository appRoleRepository;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return null;
    }

    @Override
    public List<AppUser> listUsers() {
        return null;
    }
}
