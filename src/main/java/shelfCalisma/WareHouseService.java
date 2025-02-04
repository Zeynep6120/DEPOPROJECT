package shelfCalisma;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WareHouseService {
    private static final Scanner input = new Scanner(System.in);
    private final Map<Integer, ProductPOJO> productList = new HashMap<>();
    private final Map<Integer, Integer> shelfMap = new HashMap<>(); // Rafların doluluk durumunu takip eder
    private static final int SHELF_COUNT = 10; // Toplam raf sayısı
    private static final int SHELF_CAPACITY = 100; // Her rafın kapasitesi
    private int productIdCounter = 1000; // Benzersiz ID başlatma

    public WareHouseService() {
        // Başlangıçta tüm rafları boş olarak başlatıyoruz
        for (int i = 1; i <= SHELF_COUNT; i++) {
            shelfMap.put(i, 0); // Her raf başlangıçta 0 birim ürün içeriyor
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n---- Depo Ana Menüsü ----");
            System.out.println("1. Ürün Tanımla");
            System.out.println("2. Ürünleri Görüntüle");
            System.out.println("3. Yeni Ürün Miktarı Ekle");
            System.out.println("4. Ürünü Rafa Yerleştir");
            System.out.println("5. Ürün Çıkışı Yap");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi girin: ");
            choice = input.nextInt();
            input.nextLine(); // Satır sonunu tüket

            switch (choice) {
                case 1:
                    productDefine();
                    break;
                case 2:
                    productView();
                    break;
                case 3:
                    newProduct();
                    break;
                case 4:
                    shelfAssign();
                    break;
                case 5:
                    outOfProduct();
                    break;
                case 6:
                    System.out.println("Depo sisteminden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
                    break;
            }
        } while (choice != 6);
    }

    public void productDefine() {
        System.out.print("Ürün ismini girin: ");
        String name = input.nextLine();
        System.out.print("Üreticiyi girin: ");
        String manufacturer = input.nextLine();
        System.out.print("Birimini girin: ");
        String unit = input.nextLine();

        int id = generateUniqueId();
        int quantity = 0;
        String shelf = "-";

        ProductPOJO newProduct = new ProductPOJO(id, name, manufacturer, quantity, unit, shelf);
        productList.put(id, newProduct);
        System.out.println("Ürün başarıyla tanımlandı: " + newProduct);
    }

    public void productView() {
        System.out.println("\nID         İsim       Üretici     Miktar     Birim      Raf");
        System.out.println("-------------------------------------------------------------");
        for (ProductPOJO product : productList.values()) {
            System.out.println(product);
        }
    }

    private int generateUniqueId() {
        return productIdCounter++;
    }

    // Raf yerleştirme metodu
    public void shelfAssign() {
        System.out.println("\n---- Raf Durumu ----");

        // Raf doluluk durumunu göster
        for (int i = 1; i <= SHELF_COUNT; i++) {
            int currentQuantity = shelfMap.get(i);
            System.out.println("Raf " + i + ": " + currentQuantity + "/" + SHELF_CAPACITY);
        }

        // Kullanıcıdan ürün eklemek istediği raf ve miktar bilgilerini al
        System.out.print("Ürün eklemek istediğiniz raf numarasını girin (1-" + SHELF_COUNT + "): ");
        int selectedShelf = input.nextInt();

        // Raf numarasının geçerliliğini kontrol et
        if (selectedShelf < 1 || selectedShelf > SHELF_COUNT) {
            System.out.println("Geçersiz raf numarası. Lütfen 1 ile " + SHELF_COUNT + " arasında bir numara girin.");
            return;
        }

        System.out.print("Eklemek istediğiniz ürün miktarını girin: ");
        int quantityToAdd = input.nextInt();

        // Mevcut miktar ve kapasiteyi kontrol et
        int currentQuantity = shelfMap.get(selectedShelf);
        if (currentQuantity + quantityToAdd > SHELF_CAPACITY) {
            System.out.println("Hata: Bu kadar ürün eklemek kapasiteyi aşar! Mevcut kapasite: " + (SHELF_CAPACITY - currentQuantity));
        } else {
            // Rafı güncelle
            shelfMap.put(selectedShelf, currentQuantity + quantityToAdd);
            System.out.println("Ürün başarıyla eklendi. Raf " + selectedShelf + " şu anda " + shelfMap.get(selectedShelf) + "/" + SHELF_CAPACITY + " dolu.");
        }
    }

    public void newProduct() {
        // Yeni ürün miktarı eklemek için kod burada olacak
    }

    public void outOfProduct() {
        // Ürün çıkışı işlemi burada olacak
    }
}

