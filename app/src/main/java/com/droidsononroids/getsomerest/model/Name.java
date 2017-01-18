package com.droidsononroids.getsomerest.model;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("first")
    public String first;
    @SerializedName("last")
    public String last;

    @Override
    public String toString() {
        return String.format("%s %s", first, last);
    }
}

