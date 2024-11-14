class KomputerVIP extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean vipCard;
    // To do: Buatlah constructor pada class KomputerVIP
    public KomputerVIP(boolean vipCard, int JumlahKomputer, String NamaWarnet, float hargaPerJam) {
        super(JumlahKomputer, NamaWarnet, hargaPerJam);
        this.vipCard = vipCard;
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    public void Informasi() {
        super.informasi();
        if (vipCard) {
            System.out.println("Status: Member VIP");
            System.out.println("Benefit Member VIP:");
            System.out.println("- Diskon 10% untuk bermain di atas 3 jam");
            System.out.println("- Gratis minuman setiap 4 jam bermain");
            System.out.println("- Prioritas booking komputer gaming");
        } else {
            System.out.println("Status: Member Non VIP");
            System.out.println("Benefit Member VIP: Anda bukan member VIP");
        }
    }
    // To do: Buatlah method Login sesuai dengan ketentuan
    public void Login(String username) {
        System.out.println("Login dengan username: " + username);
    }
    // To do: Buatlah method Bermain sesuai dengan ketentuan
    public void Bermain(int Jam) {
        System.out.println("Bermain selama: " + Jam);
    }
    // To do: Buatlah method Bermain memakai Polymorphism Overloading sesuai dengan ketentuan

}