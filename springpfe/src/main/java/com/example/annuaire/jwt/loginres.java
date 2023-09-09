package com.example.annuaire.jwt;

public class loginres {
    private String token;
    private String username;
    private String role;

    public loginres(String token) {
        this.token = token;
      
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
