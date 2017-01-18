package com.droidsononroids.getsomerest.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserResponse {

    @SerializedName("results")
    private List<User> mUsers;

    @Override
    public String toString() {
        String users = "Size: " + mUsers.size() + "\n";
        for (final User user : mUsers) {
            users += user.toString() + "\n";
        }
        return users;
    }
}
