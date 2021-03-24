import java.util.ArrayList;

//public class MäluTabel implements Tabel{


public class MäluTabelTööd {
ArrayList<Töö> tööTabel = new ArrayList<>();

public void lisaTöö(Töö töö) {
    System.out.println("Mälutabel - lisaAuto");
    tööTabel.add(töö);
}


// @Override
public boolean kustutaTöö(int reaNr) {
    System.out.println("Mälutabel - kustutaAuto");
    if (reaNr > 0 && reaNr <= tööTabel.size()) {
        tööTabel.remove(reaNr-1);
        return true;
    } else {
        return false;
    }
}

//  @Override
public String prindiTööTabel() {
    System.out.println("Mälutabel - prindiTööTabel");
    if (tööTabel.isEmpty()) {
        return "Tabel on tühi!";
    }
    int tööVäljaPikkus = tööVäljaPikkus();
    int lisaInfoPikkus = lisaInfopikkus();
    String tööVäljaPäis = "Töö kirjeldus";
    String lisaInfoPäis = "Lisainfo töö kohta";
    tööVäljaPäis = String.format("%1$-" + tööVäljaPikkus + "s", tööVäljaPäis);
    lisaInfoPäis = String.format("%1$-" + lisaInfoPikkus + "s", lisaInfoPäis);

    StringBuilder sb = new StringBuilder();
    sb.append("|Nr |" + tööVäljaPäis + "|" + lisaInfoPäis + "|\n");

    // int i = 1;    // Asendasin AutoId - ga

    for (Töö töö: tööTabel) {
        sb.append("|");
        sb.append(String.format("%1$-3s", töö.getAutoId()));
        sb.append("|");
        sb.append(String.format("%1$-" + tööVäljaPikkus +"s", töö.getTööNimi()));
        sb.append("|");
        sb.append(String.format("%1$-" + lisaInfoPikkus +"s", töö.getLisainfo()));
        sb.append("|");
        sb.append("\n");
    }
    return sb.toString();
}

private int tööVäljaPikkus() {
    int pikkus = 0;

    for (Töö i: tööTabel) {
        if (i.getTööNimi().length() > pikkus) {
            pikkus = i.getTööNimi().length();
        }
    }

    return pikkus;
}
private int lisaInfopikkus() {
    int pikkus = 0;

    for (Töö i: tööTabel) {
        if (i.getLisainfo().length() > pikkus) {
            pikkus = i.getLisainfo().length();
        }
    }

    return pikkus;
}
}
