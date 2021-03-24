import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

//public class FailiTabel implements Tabel {
    public class FailiTabel{
    private static Path fail;


    public FailiTabel(String failiNimi) {

        try {
            this.fail = Path.of(failiNimi);
            if (!Files.exists(fail)) {
                Files.createFile(Path.of(failiNimi));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void lisaAuto(Auto auto) {
        System.out.println("Failitabel - lisaAuto");
        String autoRida = auto.getId() + "," + auto.getKuupäev() + "," + auto.getVin() + "," + auto.getMark() + "," + auto.getMudel() + "," + auto.getKlient() + "," + auto.getAsukoht() + "," + auto.getTöödeNimekiri() + "\n";
        try {
            Files.writeString(fail, autoRida, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public boolean kustutaAuto(int reaNr) {
        System.out.println("Failitabel - kustutaAuto");
        try {
            List<String> read = Files.readAllLines(fail);
            if (reaNr > 0 && reaNr <= read.size()) {
                read.remove(reaNr - 1);
                Files.write(fail, read, StandardOpenOption.TRUNCATE_EXISTING);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String prindiTabel() {
        System.out.println("Failitabel - prindiTabel");
        try {
            List<String> read = Files.readAllLines(fail);
            StringBuilder uuedRead = new StringBuilder();

            int i = 1;                                      // rea loendur
            for (String rida : read) {
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

    public void lisaTöö(Töö uusTöö) {
        System.out.println("Failitabel - lisaTöö");
        System.out.println(uusTöö.toString());

    }
}
