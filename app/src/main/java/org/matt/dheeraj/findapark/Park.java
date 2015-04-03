package org.matt.dheeraj.findapark;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Matt on 3/31/2015.
 */
public class Park implements Parcelable{

    //Public Methods
    public String getName() {return name;}
    public int getRating() {
        if (ratingCounter > 0)
            return (ratingSum / ratingCounter);

        else
            return 0;
    }
    public void addRating(int newRating) {
        if ((newRating > 0) && (newRating < 6)){
            ratingCounter++;
            ratingSum += newRating;
        }
        else
            throw new IllegalArgumentException();
    }


    // Parcelable methods
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeInt(ratingSum);
        dest.writeInt(ratingCounter);
    }
    private void readFromParcel(Parcel in){
        name = in.readString();
        ratingSum = in.readInt();
        ratingCounter = in.readInt();
    }
    public int describeContents(){
        return CONTENTS_FILE_DESCRIPTOR ;
    }
    public Park(Parcel in){
        name = in.readString();
        ratingSum = in.readInt();
        ratingCounter = in.readInt();
    }

    //Constructor(s)
    public Park (String n){
        name = n;
    }
    public Park (){throw new UnsupportedOperationException();}


    //Private Members
    private String name;
    private int ratingSum;
    private int ratingCounter;
    private LatLng latLng;

    //List<ParkFeature> features;
    //List<ParkComment> comments;

    //Private Methods
    public static final Parcelable.Creator<Park> CREATOR = new Parcelable.Creator<Park>() {
        public Park createFromParcel(Parcel in) {
            return new Park(in);
        }

        public Park[] newArray(int size) {
            return new Park[size];
        }
    };
}
