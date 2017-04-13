package com.example.kaan.appcent.Model;

/**
 * Created by kaan on 12.04.2017.
 */


public class SearchResponse
{

    private Meta meta;
    private Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
