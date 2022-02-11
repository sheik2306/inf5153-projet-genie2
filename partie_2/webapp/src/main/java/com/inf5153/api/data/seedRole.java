package com.inf5153.api.data;

import com.inf5153.api.daos.RoleDAO;
import com.inf5153.api.models.Role;
import com.inf5153.api.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class seedRole {
    
    @Autowired
	RoleDAO roleDAO;

    @Autowired
    RoleService roleService;

    @EventListener
	private void loadUserData(ContextRefreshedEvent event) {
            if (roleService.count() == 0) {      
                Role roleDoctor = new Role("Doctor");
                roleService.createOrSave(roleDoctor);
                Role roleHealthProffessional = new Role("Health Proffessional");
                roleService.createOrSave(roleHealthProffessional);

            }
	}
}
