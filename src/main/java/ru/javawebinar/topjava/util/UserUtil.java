package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static List<User> users = Arrays.asList(
            new User(null, "First user", "first@mail.com", "password", Role.USER),
            new User(null, "Second user", "second@mail.com", "password", Role.USER),
            new User(null, "Firs admin", "first@mail.com", "password", Role.USER, Role.ADMIN),
            new User(null, "Third user", "first@mail.com", "password", Role.USER),
            new User(null, "Fourth user", "first@mail.com", "password", Role.USER),
            new User(null, "Second admin", "first@mail.com", "password", Role.USER, Role.ADMIN)
    );
}
