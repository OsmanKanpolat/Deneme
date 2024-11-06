package storageProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static ArrayList<Product> urunlistesi = new ArrayList<>();
    public static int idSayac = 1000;

    //Menüyü ve işlemleri çalıştıran metod

      public void runMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean dongu = true;


        // Ana menuyu yazdiran metot
        while (dongu) {
            System.out.println("\n====== Depo Yönetim Sistemi ======");
            System.out.println("1. Ürün Tanımlama");
            System.out.println("2. Ürün Listeleme");
            System.out.println("3. Ürün Girişi");
            System.out.println("4. Ürünü Rafa Koyma");
            System.out.println("5. Ürün Çıkışı");
            System.out.println("6. Çıkış");
            System.out.print("Lütfen bir işlem seçiniz: ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    urunTanimlama();
                    break;
                case 2:
                    urunListele();
                    break;
                case 3:
                    urunGirisi();
                    break;
                case 4:
                    urunuRafaKoy();
                    break;
                case 5:
                    urunCikisi();
                    break;
                case 6:
                    System.out.println("Sistemden çıkılıyor...");
                    dongu = false;
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }




    public static void urunTanimlama() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ürün Ismi : ");
        String name = input.nextLine();
        System.out.println("Üretici : ");
        String manufacturer = input.nextLine();
        System.out.println("Birim : ");
        String unit = input.nextLine();

        Product yeniUrun = new Product( idSayac++,name , manufacturer, unit); //idsayac ekle
        urunlistesi.add(yeniUrun); //Arraylistte urunu listeye ekledik.

        System.out.println("Ürün başarıyla tanımlandı.");
        //System.out.println("Ürün başarıyla tanımlandı." + yeniUrun);
             // tryAgain();


    }

    public static void urunListele() {

        System.out.println("----------Urun Listesi -------");   // Urun tanimlama kodu buraya gelecek
         /*if (urunlistesi.isEmpty()){
             System.out.println("depoda tanımlı ürün bulunmamaktadır.");
         }else {

         }*/
        for (Product product : urunlistesi) {
            System.out.println(" id:  " +  product.id + "  isim:  " + product.name + " uretici:  " + product.manufacturer
                    + " miktar : " + product.quantity
                    + " birim : " + product.unit + "  raf :  " + product.shelf);
        }
    // }} tryAgain();

        // System.out.println("id \n productName \n manifacturer \n quantity\n unit\n shelf");


        System.out.println("Ürün Listeleme işlemi seçildi.");
        // Urun listeleme kodu buraya gelecek


    }

    public static void urunGirisi() {
        System.out.println("Ürün Girişi işlemi seçildi.");
        // Urun girisi kodu buraya gelecek
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ürün id: ");
        int id = scanner.nextInt();
        System.out.print("Ürün girişi miktarı: ");
        int miktar = scanner.nextInt();

        for (Product product : urunlistesi) {
            if (product.id == id) {
                product.quantity += miktar; // Miktarı artır
                System.out.println("Ürün girişi  başarıyla yapıldı.");

                //System.out.println("Ürün girişi  başarıyla yapıldı." + product);
                //  tryAgain();
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
        //tryAgain();
    }


    public static void urunuRafaKoy() {
        System.out.println("Ürünü Rafa Koyma işlemi seçildi.");
        // Urunu rafa koyma kodu buraya gelecek

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ürün ID'sini giriniz: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini temizle
        System.out.print("Raf numarasi giriniz: ");
        String raf = scanner.nextLine();

        for (Product product : urunlistesi) { // urunler ismi  burda arraylistten geliyor
            if (product.id == id) {
                product.shelf = raf;
                System.out.println("Ürün başarıyla rafa yerleştirildi.");
               // System.out.println("Ürün başarıyla rafa yerleştirildi." + product);
                //tryAgain();
                return;
            }
        }
        System.out.println("Bu ID ile eşleşen ürün bulunamadı.");
        //tryAgain();

    }

    public static void urunCikisi() {
        System.out.println("Ürün Çıkışı işlemi seçildi.");
        // Ürün cikis kodlari buraya gelecek

        Scanner scanner = new Scanner(System.in);
        System.out.println("urun id numarasini giriniz");
        int id = scanner.nextInt();
        System.out.println("urun cikis miktari giriniz");
        int quantity = scanner.nextInt();

        for (Product product : urunlistesi) {
            if (product.id == id) {

                if (product.quantity < quantity) {
                    System.out.println("yetersiz stok");

                } else {
                    product.quantity -= quantity;
                    System.out.println("urun cikisi yapildi");
                }
                //tryAgain();
                return;
            }

        }
        System.out.println("urun bulunamadi ");
        //tryAgain();
    }

   /* public void tryAgain() {
          Scanner input = new Scanner(System.in);
        System.out.print("Başka bir işlem yapmak istiyor musunuz? (E/H): ");
        String cevap = input.next();

        if (cevap.equalsIgnoreCase("E")) {
            runMenu();
        } else {
            System.out.println("Sistemden çıkılıyor...");
        }*/
    }


