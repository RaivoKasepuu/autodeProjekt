import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Actions {

    public static void lisaAutoTest() {


        LocalDate loomiseKuupäev = LocalDate.now();
        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Integer id = IdGeneraator.getNextId();

        String vinTähis = "VIN1234567";
        String mark = "Audi";
        String mudel = "A4";
        String klient = "Kalmer Tennossaar";
        String asukoht = "Tapa";

        Auto uusAuto = new Auto(id, loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);
        FailiTabel.lisaAuto(uusAuto);

        System.out.println("Uus Auto edukalt sisestatud!");
        System.out.println(uusAuto.toString());
    }

    static void lisaAutoMenüü() {

        Scanner sisend = new Scanner(System.in);

        System.out.println("Sisesta kuupäev formaadis YYYY-MM-DD: ");
        String kuupäev = sisend.nextLine();
        LocalDate loomiseKuupäev = LocalDate.now();

        if (kuupäev.length() != 0) {
            loomiseKuupäev = LocalDate.parse(kuupäev);
        }

        System.out.println("Sisesta VIN tähis: ");
        String vinTähis = sisend.nextLine();

        System.out.println("Sisesta auto mark: ");
        String mark = sisend.nextLine();

        System.out.println("Sisesta auto mudel: ");
        String mudel = sisend.nextLine();

        System.out.println("Sisesta kliendi nimi: ");
        String klient = sisend.nextLine();

        System.out.println("Sisesta auto asukoht: ");
        String asukoht = sisend.nextLine();

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Integer id = IdGeneraator.getNextId();

        Auto uusAuto = new Auto(id, loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);

        System.out.println("Uus Auto edukalt sisestatud!");
        System.out.println(uusAuto.toString());

    }

    static void lisaAutoMenüüAutomaatne() {

        Scanner sisend = new Scanner(System.in);

        System.out.println("Sisesta kuupäev formaadis YYYY-MM-DD: ");
        String kuupäev = sisend.nextLine();
        LocalDate loomiseKuupäev = LocalDate.now();

        if (kuupäev.length() != 0) {
            loomiseKuupäev = LocalDate.parse(kuupäev);
        }

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Integer id = IdGeneraator.getNextId();

        String vinTähis = "VIN1234567";
        String mark = "Audi";
        String mudel = "A4";
        String klient = "Kalmer Tennossaar";
        String asukoht = "Tapa";

        Auto uusAuto = new Auto(id, loomiseKuupäev, vinTähis, mark, mudel, klient, asukoht, töödeNimekiri);
        FailiTabel.lisaAuto(uusAuto);

        System.out.println("Uus Auto edukalt sisestatud!");
        System.out.println(uusAuto.toString());

    }

    static void lisaTööMenüüAutomaatne() {
        for (int i = 0; i < 5; i++) {
            Töö uusTöö = new Töö(i, "klaaside toonimine", false, "osta värvi");

        }


    }

    static void lisaTööMenüü() {

        Scanner sisend = new Scanner(System.in);

        /*
        System.out.println("Sisesta kuupäev formaadis YYYY-MM-DD: ");
        String kuupäev = sisend.nextLine();
        LocalDate loomiseKuupäev = LocalDate.now();

        if (kuupäev.length() != 0) {
            loomiseKuupäev = LocalDate.parse(kuupäev);
        }
*/
        System.out.println("Sisesta auto id: ");
        int id = Integer.parseInt(sisend.nextLine());

        System.out.println("Sisesta töö nimetus: ");
        String nimi = sisend.nextLine();

        System.out.println("Sisesta lisainfo: ");
        String lisainfo = sisend.nextLine();

        boolean tehtud = false;

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Töö uusTöö = new Töö(id, nimi, tehtud, lisainfo);


        Main.tööTabel.lisaTöö(uusTöö);

        System.out.println("Uus töö edukalt sisestatud!");

    }



}
