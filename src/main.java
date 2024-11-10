public class main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Mimo", 2, "Persia");
        Burung burung = new Burung("Ucup", 1, "Hijau");

        System.out.println("Detail Hewan\n");

        System.out.println("ini adalah Mimo !");
        kucing.suara();
        kucing.makan();
        kucing.makan("ikan");
        System.out.println();

        System.out.println("ini adalah Ucup !");
        burung.suara();
        burung.makan();
        burung.makan("biji-bijian");
        System.out.println();

        kucing.infoHewan();
        burung.infoHewan();
    }
}