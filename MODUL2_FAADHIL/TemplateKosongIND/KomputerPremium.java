class KomputerPremium extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean ruangPrivat;
    // To do: Buatlah constructor pada class KomputerPremium
    public KomputerPremium(boolean ruangPrivat, int JumlahKomputer, String NamaWarnet, float hargaPerJam) {
        super(JumlahKomputer, NamaWarnet, hargaPerJam);
        this.ruangPrivat = ruangPrivat;
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    public void Informasi() {
        super.informasi();
        if (ruangPrivat) {
            System.out.println("Status: Ruangan Premium");
            System.out.println("Benefit Member VIP:");
            System.out.println("- Diskon 10% untuk bermain di atas 3 jam");
            System.out.println("- Gratis minuman setiap 4 jam bermain");
            System.out.println("- Prioritas booking komputer gaming");
        } else {
            System.out.println("Status: Member Non VIP");
            System.out.println("Benefit Member VIP: Anda bukan member VIP");
            
        }
    }
    // To do: Buatlah method Pesan sesuai dengan ketentuan
    public void Pesan(int NomerKomputer) {
        System.out.println("Memesan Komputer Nomer: " + NomerKomputer);
        
    }
    // To do: Buatlah method TambahLayanan sesuai dengan ketentuan
    public void TambahLayanan(String Makanan) {
        System.out.println("Memesan Layanan makanan: " + Makanan);
    }
    // To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan

    
    
}
