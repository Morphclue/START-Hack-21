package de.uniks.start_hack_21.util;

import de.uniks.start_hack_21.data.User;

public class UserManagement {
    private static User user;

    public static void setUser(User newUser) {
        user = newUser;
    }

    public static User getUser() {
        return user;
    }
}
