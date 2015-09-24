package org.matt.dheeraj.findapark;

import android.content.Context;
import android.location.Address;

/**
 * Created by Matt on 4/10/2015.
 *
 */
public interface DBBridge {
    public boolean nameExists(String name);
    public void createPark(Park park, Context context);
    public ParkCollection findParks(Address address, Context context);
    public void updatePark(Park park, Context context);
    public FeatureList getAllFeatures();
}
