package com.example.elwis.ucarereadytohelp;

import android.os.Parcel;
import android.os.Parcelable;

import org.w3c.dom.Text;

public class Post implements Parcelable {



    private String Reference;

    // constructor
    public Post() {

    }



    public void setReference(String text, Post referenceid) {
        this.Reference = text;
    }

    // getters


    public String getReference() {
        return Reference;
    }

    // 99.9% of the time you can just ignore this
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {

        out.writeString(Reference);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[0];
        }


    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Post(Parcel in) {

        Reference = in.readString();
    }

}