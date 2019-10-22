package co.drillapp.whiskey_app.entities;

import java.time.LocalDateTime;

public class WhiskeyRecord {

    private LocalDateTime record;

    public WhiskeyRecord() {
        this.record = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public LocalDateTime getRecord() {
        return record;
    }

    public void setRecord(LocalDateTime record) {
        this.record = record;
    }
}
