package com.fooddeliveryapp.storefront.models;

import com.fooddeliveryapp.storefront.models.User;

import java.util.List;

public class UsersInfo {
    private List<User> users;

    public UsersInfo() {
    }

    public UsersInfo(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
