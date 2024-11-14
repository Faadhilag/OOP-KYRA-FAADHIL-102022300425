public class Komputer {
    // To do: Buatlah 3 variable sesuai ketentuan
    protected  int JumlahKomputer;
    protected String NamaWarnet;
    protected float hargaPerJam;
    
    // To do: Buatlah constructor pada class Komputer
    public Komputer(int JumlahKomputer, String NamaWarnet, float hargaPerJam) {
        this.JumlahKomputer = JumlahKomputer;
        this.NamaWarnet = NamaWarnet;
        this.hargaPerJam = hargaPerJam;
    }
    // To do: Buatlah Method Informasi dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    public void informasi() {
        System.out.println("Jumlah komputer :" + JumlahKomputer);
        System.out.println("Nama Warnet :" + NamaWarnet);
        System.out.println("Harga per Jam :" + hargaPerJam);
    }

}