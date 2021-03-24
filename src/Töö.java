public class Töö {
    private int autoId;         // Auto ID, millele töö lisatakse
    private String tööNimi;     // Töö sisu
    private boolean tehtud;     // Kui töö tehtud, siis true, kui tegemata, siis false
    private String lisainfo;    // Lisainfo töö kohta (tähtaeg, alltöövõtja, kust materjale hankida jms)

    public Töö(int autoId, String tööNimi, boolean tehtud, String lisainfo) {
        this.autoId = autoId;
        this.tööNimi = tööNimi;
        this.tehtud = tehtud;
        this.lisainfo = lisainfo;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getTööNimi() {
        return tööNimi;
    }

    public void setTööNimi(String tööNimi) {
        this.tööNimi = tööNimi;
    }

    public boolean isTehtud() {
        return tehtud;
    }

    public void setTehtud(boolean tehtud) {
        this.tehtud = tehtud;
    }

    public String getLisainfo() {
        return lisainfo;
    }

    public void setLisainfo(String lisainfo) {
        this.lisainfo = lisainfo;
    }

    @Override
    public String toString() {
        return "Töö{" +
                "autoId=" + autoId +
                ", tööNimi='" + tööNimi + '\'' +
                ", tehtud=" + tehtud +
                ", lisainfo='" + lisainfo + '\'' +
                '}';
    }
}
