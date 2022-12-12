<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Photo Sharing with Firebase
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/Giri%C5%9F.gif" align="right" height="300">

<img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase.png" height="30"> Firebase çalışması için yapılmış, orta seviye android uygulama geliştirme projesidir. [Atıl Samancıoğlu'nun BTK akademi'de verdiği eğitimdeki](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274) proje baz alınarak çalışılmıştır.

[*📢Firebase hakkında detaylı bilgi için Veritabanı İşlemleri notunu inceleyebilirsiniz.*](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md)

## Proje Yapılış Aşamaları

Takip edilen adımlar:

1. [Firebase bağlantısı](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#firebase-ba%C4%9Flant%C4%B1s%C4%B1) ve ekstra gereken Authentication, Cloud Firestore, Cloud Storage kütüphaneleri 📍 build.gradle(app)'daki `dependencies` kısmına eklendi.

    ```kotlin
    dependencies {
        ...
        implementation 'com.google.firebase:firebase-auth-ktx'
        implementation 'com.google.firebase:firebase-firestore-ktx'
        implementation 'com.google.firebase:firebase-storage-ktx'
    }
    ```

2. [activity_main.xml](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/photoSharingwithFirebase#kullan%C4%B1c%C4%B1-aray%C3%BCz-%C3%A7al%C4%B1%C5%9Fmas%C4%B1), login sayfası olarak tasarlandı
3. feedActivity adında boş bir aktivite oluşturuldu.
4. activity_feed.xml dosyası düzenlendi. 
   
   > 📢 *Bu kısımda recycleView kullanıldı. RecycleView Kullanımının detaylı açıklaması için ["super hero books" projesini](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/superHeroBooks) inceleyebilirsiniz.*

5. [Firebase Authentication](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#firebase-authentication-i%C5%9Flemleri) işlemleri yapıldı. 

## Kullanıcı Arayüz Çalışması

1. Login işlemi için activity_main.xml düzenlendi.

    <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/photoSharingWithFirebase/LoginView.png" height="150">

2. activity_feed.xml [RecyclerView](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/superHeroBooks) eklendi.

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/%C4%B0%C5%9FimBittiSanm%C4%B1%C5%9F%C4%B1md%C4%B1r.gif" align="right">


## Kaynakça :card_file_box:

1. [Kotlin İle Android Mobil Uygulama Geliştirme İleri Seviye, Atıl Samancıoğlu, *BTK Akademi*](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-ileri-seviye-10359)
2. [Developer Guides | Android Developers](https://developer.android.com/guide)
3. [Firebase Docs](https://firebase.google.com/docs/android/setup#kotlin+ktx_2)

---

## İletişim :telephone_receiver:

:e-mail:  softwaredeveloperarchive@gmail.com

:iphone: [@softwaredeveloperarchive](https://www.instagram.com/softwaredeveloperarchive/)