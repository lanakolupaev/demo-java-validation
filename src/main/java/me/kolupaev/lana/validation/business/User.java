package me.kolupaev.lana.validation.business;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
public class User {
    private long id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    @Size(min = 5, max = 50)
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    @Size(min=8, max = 50)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
