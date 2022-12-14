<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Photo Sharing with Firebase
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/Giri%C5%9F.gif" align="right" height="300">

<img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase.png" height="30"> Firebase çalışması için yapılmış, orta seviye android uygulama geliştirme projesidir. [Atıl Samancıoğlu'nun BTK akademi'de verdiği eğitimdeki](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274) proje baz alınarak çalışılmıştır.

***Projenin nasıl yapıldığını incelemek için [Software Developer Archive youtube kanalımdan 🎬](https://www.youtube.com/watch?v=lRVqH66BF7Y&ab_channel=SoftwareDeveloperArchive) videoyu izleyebilirsiniz..***

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
6. Menu eklendi. FeedActivity kısmından eklenen yeni menu için fonksiyonlar override edildi.
   
   📍 res/menu oluşturuldu. İçerisine yeni menu dosyası oluşturuldu. İstenilen logOut ve Share Photo seçenekleri yeni menuye eklendi.

7. activity_sharePhoto düzenlendi
8. Telefon hafızanını okumak için izin istendi. Bunun için 📍 manifest klasöründeki dosya düzenlendi.
   ```kotlin
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"></uses-permission>
   ```
9. sharePhotoActivity içerisine, galeriden fotograf seçilebilemesi için aşağıdaki kodlar eklendi:

    📌 Gerekli izinler alındıysa galeriye yönlendirilir.

    ```kotlin

    fun SelectImg(view:View) {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }else{
                val ımages = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(ımages,2)
            }
        }

    ```

    📌Gerekli iznin verilip verilmediği durumların sonuçları için:

    ```kotlin
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            if(requestCode==1){
                if(grantResults.size>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    val ımages = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(ımages,2)
                }
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            if(requestCode==2&&resultCode== RESULT_OK && data!=null){
                chosenImg = data.data

                if(chosenImg != null){

                    if(Build.VERSION.SDK_INT >= 28){
                        val source = ImageDecoder.createSource(this.contentResolver,chosenImg!!)
                        chosenBitmap = ImageDecoder.decodeBitmap(source)
                        SelectView.setImageBitmap(chosenBitmap)
                    }else{
                        chosenBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,chosenImg)
                        SelectView.setImageBitmap(chosenBitmap)
                    }

                }
            }
            super.onActivityResult(requestCode, resultCode, data)
        }

    ```
10. Cloud Storage ve Cloud Firestore ayarları yapıldı. Firestore console üzerinden kural değişikliği yapıldı.
11. Veritabanına seçilen görseli kaydetmek için:

    📌 Sınıfa ait değişkenler tanımlandı.

    ```kotlin
        private lateinit var storage: FirebaseStorage
        private lateinit var auth: FirebaseAuth
        private lateinit var database: FirebaseFirestore
    ```

    📌 Aktivite oluştuğunda, tanımlanan değişkenlere değerler atandı.

    ```kotlin
        storage = FirebaseStorage.getInstance()
        auth= FirebaseAuth.getInstance()
        database= FirebaseFirestore.getInstance()
    ```
    📌 Fotograflar veritabanına kaydedildi.

    ```kotlin
        fun Share(view: View){

            val uuid = UUID.randomUUID()
            val ımgName = "${uuid}.jpg"

            val reference = storage.reference

            val ımgRef = reference.child("images",).child(ımgName)

            if(chosenImg != null){
                ımgRef.putFile(chosenImg!!).addOnSuccessListener { taskSnapshot ->
                    println("Upload Succesfull")
                }
            }
        }   
    ```


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
