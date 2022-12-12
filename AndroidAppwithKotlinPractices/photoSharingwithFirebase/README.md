<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Photo Sharing with Firebase
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/Giri%C5%9F.gif" align="right" height="300">

<img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase.png" height="30"> Firebase çalışması için yapılmış, orta seviye android uygulama geliştirme projesidir. [Atıl Samancıoğlu'nun BTK akademi'de verdiği eğitimdeki](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274) proje baz alınarak çalışılmıştır.

## Proje Yapılış Aşamaları

Takip edilen adımlar:

1. [Firebase](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/photoSharingwithFirebase#-firebase-i%CC%87%C5%9Flemleri) bağlantısı ve ekstra gereken Authentication, Cloud Firestore, Cloud Storage kütüphaneleri eklendi.
2. [activity_main.xml](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/photoSharingwithFirebase#kullan%C4%B1c%C4%B1-aray%C3%BCz-%C3%A7al%C4%B1%C5%9Fmas%C4%B1), login sayfası olarak tasarlandı
3. feedActivity adında boş bir aktivite oluşturuldu.
4. activity_feed.xml dosyası düzenlendi. 
   
   > 📢 *Bu kısımda recycleView kullanıldı. RecycleView Kullanımının detaylı açıklaması için ["super hero books" projesini](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/tree/main/AndroidAppwithKotlinPractices/superHeroBooks) inceleyebilirsiniz.*

5. [Firebase Authentication](https://firebase.google.com/docs/auth/android/start) işlemleri yapıldı. 

    📌Kullanılacak referans değer sınıf içerisinde tanımlandı
    ```kotlin
    // global değişken tanımlandı

    private lateinit var auth:FirebaseAuth

    // Aktivite'nin onCreate() fonksiyonu içerisinde auth'a değer atandı

    auth = FirebaseAuth.getInstance()
    ```

    📌 Login işlemi:
    ```kotlin
    fun login(view:View){

        val email = EmailText.text.toString()
        val password = PasswordText.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){

                val user = auth.currentUser?.email.toString()

                Toast.makeText(this,"Welcome: ${user}",Toast.LENGTH_LONG).show()

                val intent =Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }
    ```

    📌 Kayıt olma işlemi yapıldı:
    ```kotlin

    fun register(view: View){

        val email = EmailText.text.toString()
        val password = PasswordText.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

     }

    ```

    📌 Güncel kullanıcı bilgilerinin hatırlanması için aktivitenin onCreate() fonksiyonu içerisine aşağıdaki kod bloğu eklendi:
    
    ```kotlin
        val user = auth.currentUser
        if(user!=null){
            val intent =Intent(this,FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    ```

## <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase.png" height="30"> Firebase İşlemleri

1. Firebase bağlantısı yapıldı. [*(Firebase nedir? Firebase Bağlantısı nasıl yapılır? gibi sorular için Veritabanı işlemleri notuma bakabilirsiniz..)*](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md)
2. [Firebase kütüphanelerinden](https://firebase.google.com/docs/android/setup#kotlin+ktx_2) ihtiyaç duyulan: Authentication, Cloud Firestore, Cloud Storage kütüphaneleri 📍 build.gradle(app)'daki `dependencies` kısmına eklendi.

    ```kotlin
    dependencies {
        ...
        implementation 'com.google.firebase:firebase-auth-ktx'
        implementation 'com.google.firebase:firebase-firestore-ktx'
        implementation 'com.google.firebase:firebase-storage-ktx'
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