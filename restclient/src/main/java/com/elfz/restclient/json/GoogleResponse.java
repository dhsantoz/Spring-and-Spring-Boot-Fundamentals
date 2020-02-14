package com.elfz.restclient.json;

import java.util.List;

public class GoogleResponse {

    private List<Result> results;
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLat(){
        return this.getResults().get(0).getGeometry().getLocation().getLat();
    }

    public double getLng(){
        return this.getResults().get(0).getGeometry().getLocation().getLng();
    }

    public String getAddress(){
        return this.getResults().get(0).getFormattedAddress();
    }


    @Override
    public String toString() {
        return "GoogleResponse{" +
                "results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
