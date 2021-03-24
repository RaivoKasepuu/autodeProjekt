import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

//public class FailiTabel implements Tabel {
    public class FailiTabelTööd {
    private static Path tööFail;


    public FailiTabelTööd(String failiNimi) {

        try {
            this.tööFail = Path.of(failiNimi);
            if (!Files.exists(tööFail)) {
                Files.createFile(Path.of(failiNimi));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void lisaTöö(Töö töö) {
        System.out.println("FailiTabelTööd - lisaTöö");
        String tööRida = töö.getAutoId() + "," + töö.getTööNimi() + "," + töö.getLisainfo() + "\n";
        System.out.println(tööRida);
        try {
           // Path tööfail = null;
            Files.writeString(tööFail, tööRida, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public boolean kustutaTöö(int tööReaNr) {
        System.out.println("Failitabel - kustutaAuto");
        try {
            List<String> read = Files.readAllLines(tööFail);
            if (tööReaNr > 0 && tööReaNr <= read.size()) {
                read.remove(tööReaNr - 1);
                Files.write(tööFail, read, StandardOpenOption.TRUNCATE_EXISTING);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String prindiTööTabel() {
        System.out.println("FailiTabelTööd - prindime tööde tabeli failist");
        System.out.println(tööFail);
        try {
            List<String> töödeRead = Files.readAllLines(tööFail);
            StringBuilder uuedRead = new StringBuilder();

            int i = 1;                                      // rea loendur
            for (String rida : töödeRead) {
                uuedRead.append(i + "," + rida);
                uuedRead.append("\n");
                i++;
            }

            return uuedRead.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
