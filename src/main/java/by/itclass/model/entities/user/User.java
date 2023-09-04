package by.itclass.model.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.StringJoiner;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class User {
    private int id;
    private final String login;
    private final String name;
    private final String email;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("login='" + login + "'")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
