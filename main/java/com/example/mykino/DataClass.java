package com.example.mykino;

public class DataClass {

    private String dataTitle;
    private String dataDescription;
    private String dataAge;
    private int dataImage;


    private String dataYear;

    private String dataGanr;
    private String dataTime;
    private String dataDirector;

    public DataClass(String dataTitle, String dataDescription, String dataAge, int dataImage, String dataYear, String dataGanr, String dataTime, String dataDirector) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataAge = dataAge;
        this.dataImage = dataImage;
        this.dataYear = dataYear;
        this.dataGanr = dataGanr;
        this.dataTime = dataTime;
        this.dataDirector = dataDirector;
    }




    public String getDataYear() {
        return dataYear;
    }

    public String getDataGanr() {
        return dataGanr;
    }

    public String getDataTime() {
        return dataTime;
    }

    public String getDataDirector() {
        return dataDirector;
    }




    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public String getDataAge() {
        return dataAge;
    }

    public int getDataImage() {
        return dataImage;
    }


}
