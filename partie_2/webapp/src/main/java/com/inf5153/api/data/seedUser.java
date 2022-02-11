package com.inf5153.api.data;

import java.util.HashSet;
import java.util.Set;

import com.inf5153.api.daos.RoleDAO;
import com.inf5153.api.models.Role;
import com.inf5153.api.models.User;
import com.inf5153.api.repositories.RoleRepository;
import com.inf5153.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class seedUser {
    @Autowired
	RoleDAO roleDAO;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @EventListener
	private void loadUserData(ContextRefreshedEvent event) {
        if (userService.count() == 0) {
                Set<Role> roles = new HashSet<>();
                //Add doctor role

                roles.add(roleRepository.findRoleByName("Doctor"));
                User user = new User("test", "test", roles);
                userService.createOrSave(user);
        }
	}
}
