package com.shakil.qrcodescanning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "ticket_id",
        "scan_date",
        "scan_time",
        "status"
})

public class Ticket {

    @JsonProperty("ticket_id")
    private String ticket_id;
    @JsonProperty("scan_date")
    private String scan_date;
    @JsonProperty("scan_time")
    private String scan_time;
    @JsonProperty("status")
    private String status;

    public Ticket(String ticket_id, String scan_date, String scan_time, String status) {
        this.ticket_id = ticket_id;
        this.scan_date = scan_date;
        this.scan_time = scan_time;
        this.status = status;
    }

    @JsonProperty("ticket_id")
    public String getTicket_id() {
        return ticket_id;
    }

    @JsonProperty("ticket_id")
    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    @JsonProperty("scan_date")
    public String getScan_date() {
        return scan_date;
    }

    @JsonProperty("scan_date")
    public void setScan_date(String scan_date) {
        this.scan_date = scan_date;
    }

    @JsonProperty("scan_time")
    public String getScan_time() {
        return scan_time;
    }

    @JsonProperty("scan_time")
    public void setScan_time(String scan_time) {
        this.scan_time = scan_time;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

}
