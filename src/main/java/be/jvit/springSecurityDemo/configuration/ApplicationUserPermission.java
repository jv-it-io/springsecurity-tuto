package be.jvit.springSecurityDemo.configuration;

/**
 * @author Jonathan Vandersmissen
 * @created 3/27/2021
 * @project springSecurityDemo
 */
public enum ApplicationUserPermission {
    FAN_READ("fan:read"),
    FAN_WRITE("fan:write"),
    CATALOG_READ("catalog:read"),
    CATALOG_WRITE("catalog:write");

    private  final String permission;


    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
