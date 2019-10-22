package co.drillapp.whiskey_app.dtos;

import java.util.List;

public class DashboardDTO {

    private int total;

    private List<ChartValueDto> chartValues;

    private int avgCupsPerPerson;

    private int avg10Min;

    private int numberOfBottles;

    public DashboardDTO(int total, List<ChartValueDto> chartValues, int avgCupsPerPerson, int avg10Min, int numberOfBottles) {
        this.total = total;
        this.chartValues = chartValues;
        this.avgCupsPerPerson = avgCupsPerPerson;
        this.avg10Min = avg10Min;
        this.numberOfBottles = numberOfBottles;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ChartValueDto> getChartValues() {
        return chartValues;
    }

    public void setChartValues(List<ChartValueDto> chartValues) {
        this.chartValues = chartValues;
    }

    public int getAvgCupsPerPerson() {
        return avgCupsPerPerson;
    }

    public void setAvgCupsPerPerson(int avgCupsPerPerson) {
        this.avgCupsPerPerson = avgCupsPerPerson;
    }

    public int getAvg10Min() {
        return avg10Min;
    }

    public void setAvg10Min(int avg10Min) {
        this.avg10Min = avg10Min;
    }

    public int getNumberOfBottles() {
        return numberOfBottles;
    }

    public void setNumberOfBottles(int numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }
}
