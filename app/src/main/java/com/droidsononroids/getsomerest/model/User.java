package com.droidsononroids.getsomerest.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("phone")
    public String phone;
    @SerializedName("name")
    public Name name;

    @Override
    public String toString() {
        return String.format("Hello, my name is: %s, so call me maybe: %s", name.toString(), phone);
    }
}
