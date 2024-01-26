package com.example.lyka;

public class diseasemodel {

    int diseaseImage;
    String diseaseType;

    public diseasemodel(int diseaseImage, String diseaseType) {
        this.diseaseImage = diseaseImage;
        this.diseaseType = diseaseType;
    }

    public int getDiseaseImage() {
        return diseaseImage;
    }

    public void setDiseaseImage(int diseaseImage) {
        this.diseaseImage = diseaseImage;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }


}
