import java.util.ArrayList;

//public class MäluTabel implements Tabel{


    public class MäluTabel{
    ArrayList<Auto> autoTabel = new ArrayList<>();

    public void lisaAuto(Auto auto) {
        System.out.println("Mälutabel - lisaAuto");
        autoTabel.add(auto);
    }


   // @Override
    public boolean kustutaAuto(int reaNr) {
        System.out.println("Mälutabel - kustutaAuto");
        if (reaNr > 0 && reaNr <= autoTabel.size()) {
            autoTabel.remove(reaNr-1);
            return true;
        } else {
            return false;
        }
    }

  //  @Override
    public String prindiTabel() {
        System.out.println("Mälutabel - prindiTabel");
        if (autoTabel.isEmpty()) {
            return "Tabel on tühi!";
        }
        int kliendiVäljaPikkus = kliendiVäljaPikkus();
        int mudeliVäljapikkus = mudeliVäljapikkus();
        String kliendiPäis = "Klient";
        String mudeliPäis = "Mudel";
        kliendiPäis = String.format("%1$-" + kliendiVäljaPikkus + "s", kliendiPäis);
        mudeliPäis = String.format("%1$-" + mudeliVäljapikkus + "s", mudeliPäis);

        StringBuilder sb = new StringBuilder();
        sb.append("|Nr |Kuupäev   |       VIN       | Mark  |" + mudeliPäis + "| Asukoht  |" + kliendiPäis + "|\n");

        // int i = 1;    // Asendasin AutoId - ga

        for (Auto auto: autoTabel) {
            sb.append("|");
            sb.append(String.format("%1$-3s", auto.getId()));
            sb.append("|");
            sb.append(auto.getKuupäev());
            sb.append("|");
            sb.append(auto.getVin());
            sb.append("|");
            sb.append(String.format("%1$-7s", auto.getMark()));
            sb.append("|");
            sb.append(String.format("%1$-" + mudeliVäljapikkus +"s", auto.getMudel()));
            sb.append("|");
            sb.append(String.format("%1$-10s", auto.getAsukoht()));
            sb.append("|");
            sb.append(String.format("%1$-" + kliendiVäljaPikkus +"s", auto.getKlient()));
            sb.append("|");
            sb.append("\n");
        }
        return sb.toString();
    }

    private int kliendiVäljaPikkus() {
        int pikkus = 0;

        for (Auto i: autoTabel) {
            if (i.getKlient().length() > pikkus) {
                pikkus = i.getKlient().length();
            }
        }

        return pikkus;
    }
    private int mudeliVäljapikkus() {
        int pikkus = 0;

        for (Auto i: autoTabel) {
            if (i.getMudel().length() > pikkus) {
                pikkus = i.getMudel().length();
            }
        }

        return pikkus;
    }
}
