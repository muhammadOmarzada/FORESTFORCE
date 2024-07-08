package fxml_helloworld;

public class profilClass {
    String nama;
    String email;
    String kontak;
    String nominal;
    String bank;

    public profilClass(String nama, String email, String kontak, String nominal, String bank){
        this.nama = nama;
        this.email = email;
        this.kontak = kontak;
        this.nominal = nominal;
        this.bank = bank;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setKontak(String kontak){
        this.kontak = kontak;
    }

    public void setNominal(String nominal){
        this.nominal = nominal;
    }

    public void setBank(String bank){
        this.bank = bank;
    }

    public String getNama(){
        return nama;
    }

    public String getEmail(){
        return email;
    }

    public String getKontak(){
        return kontak;
    }

    public String getNominal(){
        return nominal;
    }

    public String getBank(){
        return bank;
    }


}
