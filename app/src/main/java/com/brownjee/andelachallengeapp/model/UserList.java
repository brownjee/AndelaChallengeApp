package com.brownjee.andelachallengeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Brownjee on 3/13/2017.
 */
public class UserList {
    @SerializedName("items")
    @Expose
    private List<User> items = null;

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
