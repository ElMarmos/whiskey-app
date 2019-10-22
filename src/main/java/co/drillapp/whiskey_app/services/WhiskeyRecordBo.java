package co.drillapp.whiskey_app.services;

import co.drillapp.whiskey_app.dtos.DashboardDTO;

public interface WhiskeyRecordBo {

    void addWhiskeyRecord();

    DashboardDTO getDashboardData();

    void setNumberOfPersons(int number);

}
