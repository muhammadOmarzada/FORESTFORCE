package fxml_helloworld;

public class proyekClass {
    String proyek;
    String progress;
    String masalah;

    public proyekClass(String proyek, String progress, String masalah){
        this.proyek = proyek;
        this.progress = progress;
        this.masalah = masalah;
    }

    public void setProyek(String proyek){
        this.proyek = proyek;
    }

    public void setProgress(String progress){
        this.progress = progress;
    }

    public void setMasalah(String masalah){
        this.masalah = masalah;
    }

    public String getProyek(){
        return proyek;
    }

    public String getProgress(){
        return progress;
    }

    public String getMasalah(){
        return masalah;
    }

}
