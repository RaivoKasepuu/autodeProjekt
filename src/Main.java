import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //static MäluTabel tabel = new MäluTabel();
    //static MäluTabelTööd tööTabel = new MäluTabelTööd();
    static FailiTabel tabel = new FailiTabel("autod.txt");
    static FailiTabelTööd tööTabel = new FailiTabelTööd("töö.txt");


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Tere tulemast autode müügiks ettevalmistamise infosüsteemi!");
        System.out.println();
        //      System.out.println("Hetkel on süsteemis järgmised autod: ");
        //    FailiTabel.prindiTabel();

        System.out.println("Auto lisamiseks vali: " + Menüü.LISA_AUTO.ordinal());
        System.out.println("Autode tabeli printimiseks vali: " + Menüü.PRINDI_TABEL.ordinal());
        System.out.println("Auto kustutamiseks vali: " + Menüü.KUSTUTA_AUTO.ordinal());
        System.out.println("Töö lisamiseks vali: " + Menüü.LISA_TÖÖ.ordinal());
        System.out.println("Tööde tabeli printimiseks vali: " + Menüü.PRINDI_TÖÖ_TABEL.ordinal());
        System.out.println("Väljumiseks vali: " + Menüü.MENÜÜST_VÄLJA.ordinal());


        Scanner valik = new Scanner(System.in);


        loop:
        while (true) {
            System.out.print("Tee valik: ");

            int input = valik.nextInt();
            switch (Menüü.values()[input]) {

                case LISA_AUTO -> {
                    Actions.lisaAutoTest();
                    //lisaAutoMenüüAutomaatne();  //kiiremaks testimiseks
                    // lisaAutoMenüü();
                    break;
                }
                case PRINDI_TABEL -> {
                    prindiTabelMenüü();
                    break;
                }
                case KUSTUTA_AUTO -> {
                    kustutaAutoMenüü();
                    break;
                }
                case LISA_TÖÖ -> {
                    lisaTööMenüü();
                    break;
                }
                case PRINDI_TÖÖ_TABEL -> {
                    prindiTööTabelMenüü();
                    break;
                }

                case MENÜÜST_VÄLJA -> {
                    break loop;
                }
            }
        }
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


    static void prindiTööTabelMenüü() {
        System.out.println("Menüü prindiTööTabelMenüü");
        tööTabel.prindiTööTabel();
    }

    static void lisaTööMenüüAutomaatne() {
        for (int i = 0; i < 5; i++) {
            Töö uusTöö = new Töö(i, "klaaside toonimine", false, "osta värvi");

        }


    }

    static void lisaTööMenüü() {

        Scanner sisend = new Scanner(System.in);

        System.out.println("Sisesta auto id: ");
        int id = Integer.parseInt(sisend.nextLine());

        System.out.println("Sisesta töö nimetus: ");
        String nimi = sisend.nextLine();

        System.out.println("Sisesta lisainfo: ");
        String lisainfo = sisend.nextLine();

        boolean tehtud = false;

        ArrayList<Töö> töödeNimekiri = new ArrayList<>();

        Töö uusTöö = new Töö(id, nimi, tehtud, lisainfo);


        tööTabel.lisaTöö(uusTöö);

        System.out.println("Uus töö edukalt sisestatud!");

    }

    static void kustutaAutoMenüü() {
        System.out.print("Sisesta auto rea nr: ");
        Scanner sc = new Scanner(System.in);
        int reaNr = sc.nextInt();
        if (tabel.kustutaAuto(reaNr)) {
            System.out.println("Auto realt nr " + reaNr + " kustutatud!");
        } else {
            System.out.println("Auto eemaldamine ebaõnnestus. Kontrolli rea numberit!");
        }

    }


    static void prindiTabelMenüü() {
        System.out.println(tabel.prindiTabel());
    }
}

enum Menüü {
    LISA_AUTO, PRINDI_TABEL, KUSTUTA_AUTO, LISA_TÖÖ, PRINDI_TÖÖ_TABEL, MENÜÜST_VÄLJA
}