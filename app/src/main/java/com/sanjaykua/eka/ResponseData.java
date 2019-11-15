package com.sanjaykua.eka;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {
    @SerializedName ("total_count")
    @Expose
    private  String totat_count;

    @SerializedName ("incomplete_results")
    @Expose
    private  String incomplete_results;

    @SerializedName ("items")
    @Expose
    private List<items> itemsList=null;

    public String getTotat_count() {
        return totat_count;
    }

    public void setTotat_count(String totat_count) {
        this.totat_count = totat_count;
    }

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<items> itemsList) {
        this.itemsList = itemsList;
    }
}
