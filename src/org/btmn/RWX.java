package org.btmn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RWX {

    private byte config;

    public void addPermission(Permission permission) {
        config |= permission.mask;
    }

    public void removePermission(Permission permission) {
        config &= ~permission.mask;
    }

    public boolean isPermitted(Permission permission) {
        return (config & permission.mask) != 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(Permission.values()).filter(this::isPermitted).map(it -> it.mark).collect(Collectors.joining());
    }

    enum Permission {
        READ("r", 4), WRITE("w", 2), EXECUTE("x", 1);

        private String mark;
        private int mask;

        Permission(String mark, int mask) {
            this.mark = mark;
            this.mask = mask;
        }
    }
}
