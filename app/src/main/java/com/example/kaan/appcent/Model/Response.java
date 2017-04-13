package com.example.kaan.appcent.Model;

import java.util.List;

/**
 * Created by kaan on 12.04.2017.
 */

public class Response
{

    private List<Venue> venues;
    private boolean confident;

    public List<Venue> getVenues()
    {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public boolean isConfident() {
        return confident;
    }

    public void setConfident(boolean confident) {
        this.confident = confident;
    }
}
