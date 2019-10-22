package co.drillapp.whiskey_app.dtos;

import co.drillapp.whiskey_app.entities.WhiskeyRecord;

public class ChartValueDto {
    private String time;

    private int quantity;

    public ChartValueDto(String time, int quantity) {
        this.time = time;
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}