package org.matt.dheeraj.findapark;

import android.content.Context;
import android.location.Address;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Matt on 6/4/2015.
 */
public class LampService implements DBBridge {
    @Override
    public boolean nameExists(String name) {
        String content = null;
        URLConnection urlConnection = null;

        try{
            urlConnection = new URL(R.string.sql_domain+"nameExists.php?name=" + name.replace(" ", "%20")).openConnection();
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception e){
            e.printStackTrace();
        }

        System.out.println(content);

        if (content.equals( "true" ))
            return true;
        else
            return false;

    }


    @Override
    public void createPark(Park park, Context context) {
        String content = null;
        String name = park.getName();
        double lat = park.getAddress().getLatitude();
        double lng = park.getAddress().getLongitude();
        double rtg = park.getRating();
        String theURL = "";
        URLConnection urlConnection = null;
        theURL += R.string.sql_domain;
        theURL += "createPark.php?";
        theURL += "name=" + name + "&lat=" + Integer.toString(lat) + "&lng=" + Integer.toString(lng) + "&rtg=" + Integer.toString(rtg);
        try{
            urlConnection = new URL(theURL).openConnection();
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public ParkCollection findParks(Address address, Context context) {
        return null;
    }

    @Override
    public void updatePark(Park park, Context context) {

    }

    @Override
    public FeatureList getAllFeatures() {
        return null;
    }
}
