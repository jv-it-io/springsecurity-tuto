package be.jvit.springSecurityDemo.configuration;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author Jonathan Vandersmissen
 * @created 3/27/2021
 * @project springSecurityDemo
 */
public enum ApplicationUserRole {
    FAN(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.CATALOG_READ,
            ApplicationUserPermission.CATALOG_WRITE,
            ApplicationUserPermission.FAN_READ,
            ApplicationUserPermission.FAN_WRITE)
    ),
    ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermission.CATALOG_READ,
          ApplicationUserPermission.FAN_READ));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }
}
