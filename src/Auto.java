import java.time.LocalDate;
import java.util.ArrayList;

public class Auto {
    private int id;                         // Auto ID, millega siinses süsteemis autot ja autoga seotud töid identifitseerime
    private LocalDate kuupäev;              // Auto süsteemi lisamise kuupärv
    private String vin;                     // Auto unikaalne VIN kood
    private String mark;                    // Auto mark
    private String mudel;                   // Auto mudel
    private String klient;                  // Kliendi nimi
    private String asukoht;                 // Auto asukoht
    private ArrayList töödeNimekiri;        // Autoga seotud tööde nimekiri


    // konstruktor Auto lisamiseks
    public Auto(Integer id, LocalDate kuupäev, String vin, String mark, String mudel, String klient, String asukoht, ArrayList töödeNimekiri) {
        this.id = id;
        this.kuupäev = kuupäev;
        this.vin = vin;
        this.mark = mark;
        this.mudel = mudel;
        this.klient = klient;
        this.asukoht = asukoht;
        this.töödeNimekiri = töödeNimekiri;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", kuupäev=" + kuupäev +
                ", vin='" + vin + '\'' +
                ", mark='" + mark + '\'' +
                ", mudel='" + mudel + '\'' +
                ", klient='" + klient + '\'' +
                ", asukoht='" + asukoht + '\'' +
                ", töödeNimekiri=" + töödeNimekiri +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getKuupäev() {
        return kuupäev;
    }

    public String getVin() {
        return vin;
    }

    public String getMark() {
        return mark;
    }

    public String getMudel() {
        return mudel;
    }

    public String getKlient() {
        return klient;
    }

    public String getAsukoht() {
        return asukoht;
    }

    public ArrayList getTöödeNimekiri() {
        return töödeNimekiri;
    }

    public void setKuupäev(LocalDate kuupäev) {
        this.kuupäev = kuupäev;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setMudel(String mudel) {
        this.mudel = mudel;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public void setAsukoht(String asukoht) {
        this.asukoht = asukoht;
    }

    public void setTöödeNimekiri(ArrayList töödeNimekiri) {
        this.töödeNimekiri = töödeNimekiri;
    }
}
