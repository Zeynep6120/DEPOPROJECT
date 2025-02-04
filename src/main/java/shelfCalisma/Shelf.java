package shelfCalisma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shelf {
    public static void main(String[] args) {


        System.out.println("Boş raflar:"); // Bu mesaj, kullanıcıya boş rafların listeleneceğini bildirmek için kullanılır.


        List<Integer> availableShelves = new ArrayList<>(); // Bu liste, kullanılabilir rafların indekslerini saklamak için kullanılır.


        boolean[] shelves = new boolean[10]; // Tüm raflar başlangıçta boş olarak ayarlandı.
        // Java'da bir boolean dizisi varsayılan olarak false değerleri ile başlatılır.
        // Yani, bu dizideki her bir eleman başlangıçta false durumundadır.



        // Boş rafları kontrol et ve listele
        for (int i = 0; i < shelves.length; i++) {
            if (!shelves[i]) { // Eğer raf boşsa
                availableShelves.add(i); // Boş rafın indeksini listeye ekle
                System.out.print("Raf " + (i + 1) + " "); // Kullanıcıya raf numarasını göster
            } else { // Eğer raf doluysa
                System.out.println("Raf " + (i + 1) + " dolu.");
            }
        }



        System.out.println(); // Boş rafların listesi bitince yeni bir satıra geç



        // Eğer boş raf yoksa
        if (availableShelves.isEmpty()) {
            System.out.println("Boş raf yok!");
            return; // Metodu sonlandır
        }

        // Kullanıcıdan raf numarasını seçmesini isteyin
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen kullanmak istediğiniz raf numarasını seçin (1-10): ");
        int selectedShelf = input.nextInt() - 1; // Kullanıcıdan raf numarasını al (0 tabanlı)


        // Geçersiz raf seçimi kontrolü
        if (selectedShelf < 0 || selectedShelf >= shelves.length || !availableShelves.contains(selectedShelf)) {
            System.out.println("Geçersiz raf seçimi!");
            return; // Metodu sonlandır
        }



        // Kullanıcıdan ürün ID'sini girmesini isteyin
        System.out.print("Lütfen yerleştirmek istediğiniz ürünün ID'sini girin: ");
        int productId = input.nextInt(); // Kullanıcıdan ürün ID'si alın



        // Ürünün varlığını kontrol etmek için bir HashMap oluşturun
        HashMap<Integer, String> productMap = new HashMap<>();
        // Örnek ürün ekleme
        productMap.put(1000, "Ürün A"); // Örnek ürünler
        productMap.put(1001, "Ürün B");



        // Ürünün varlığını kontrol et
        if (!productMap.containsKey(productId)) {
            System.out.println("Bu ID'ye sahip bir ürün bulunamadı.");
        } else {
            System.out.println("Ürün " + productMap.get(productId) + " raf " + (selectedShelf + 1) + "'ye yerleştirildi."); // Ürünü rafın üzerine yerleştirme
            shelves[selectedShelf] = true; // Rafı dolu olarak işaretle
        }

        input.close(); // Scanner'ı kapat
    }
}
