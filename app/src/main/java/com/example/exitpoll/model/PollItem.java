package com.example.exitpoll.model;

import java.util.Locale;

public class PollItem {
    public final long _id;
    public final String number;
    public final String count;
    public final String image;
    public PollItem(long _id, String number, String count, String image) {
        this._id = _id;
        this.number = number;
        this.count = count;
        this.image = image;

    }
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s",


                this.number


        );
        return msg;
    }


}
