package shelfCalisma;

public class ProductPOJO {
    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;

    // Yapıcı metod, tüm alanları başlatmak için
    public ProductPOJO(int id, String urunIsmi, String uretici, int miktar, String birim, String raf) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }

    // Getter ve setter metodları

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    // toString metodu, ürünün düzenli bir şekilde gösterilmesini sağlar
    @Override
    public String toString() {
        return String.format("%-10d %-10s %-10s %-10d %-10s %-10s", id, urunIsmi, uretici, miktar, birim, raf);
    }
}

