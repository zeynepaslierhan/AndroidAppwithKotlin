<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Veritabanı İşlemleri
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/%C4%B0%C5%9FimBittiSanm%C4%B1%C5%9F%C4%B1md%C4%B1r.gif" align="right">

## İçindekiler

1. [ :cloud: Bulut Bilişim *(Cloud)* ](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#bulut-bili%C5%9Fim-cloud-cloud)

   1. [Firebase](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#-firebase)
    
      * Giriş
      * Firebase Bağlantısı
      * Authentication İşlemleri
  
2. [Yerel *(Local)* Veritabanı](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#yerel-local-veritaban%C4%B1)

   1. SQLite

3. [Kaynakça :card_file_box:](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Veritaban%C4%B1%20%C4%B0%C5%9Flemleri.md#kaynak%C3%A7a-card_file_box)


## Bulut Bilişim *(Cloud)* 	:cloud:

### <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase.png" align="center" height="40"> Firebase

📌 **Firebase**; mobil ve web uygulamaları oluşturmak için geliştirilmiş ve cloud hizmetleri sunan bir platformdur. 

📌 **Cloud Firestore**; istemci/sunucu(client server) tarafı geliştirme için verileri depolamak ve eşitlemek için bulutta barındırılan bir NoSQL veritabanıdır. Verilerinizi koleksiyonlar halinde düzenlenmiş belgelerde saklar.

<img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase2.png" align="left" height="130">

Cloud Firestore'un NoSQL veri modelini izleyerek verileri, değerlerle eşlenen alanlar içeren belgelerde depolarsınız. Bu belgeler, verilerinizi düzenlemek ve sorgular oluşturmak için kullanabileceğiniz belgeleriniz için kapsayıcı olan koleksiyonlarda depolanır.Belgeler, basit dizeler ve sayılardan karmaşık, iç içe nesnelere kadar birçok farklı veri türünü destekler. Ayrıca belgeler içinde alt koleksiyonlar oluşturabilir ve veritabanınız büyüdükçe ölçeklenen hiyerarşik veri yapıları oluşturabilirsiniz.

</br>

#### Firebase Bağlantısı

Oluşturduğunuz android projesinin firebase entegrasyonu için:

> *Bu kısmı kendi projelerimde nasıl yaptığımı incelemek isterseniz [Photo Sharing with Firebase🎬]() projesinin youtube videosuna bakabilirsiniz.* 

1. [Firebase](https://firebase.google.com/?gclid=Cj0KCQiAnNacBhDvARIsABnDa69Z_v3xzsE3ugkUlnoXrPS7WPRxYb0uEn_evQZAZMg9dQqH52z1E4UaAuLNEALw_wcB&gclsrc=aw.ds) sayfasından yeni bir proje oluşturun. 
2. Oluşturduğunuz proje içerisinden android uygulamasını seçin
3. Firebase dokümantasyonunu takip edin.
   1. Projenin packages ismini girin
   2. İsteğe bağlı olarak:

     </br>
   
   * :bookmark:  Nickname: 📍 build.gradle(app) kısmından `applicationId`

   </br>
   
   <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase%20ba%C4%9Flant%C4%B1s%C4%B1/Nickname.gif" height="300">
  
   </br>
   
   * :bookmark:  Singing Sertificate SHA-1: 📍 Grandle/android/singingreport 

    </br>

   <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase%20ba%C4%9Flant%C4%B1s%C4%B1/SHA1.gif" height="300">

 </br>
 
 
 :bangbang: **Karşılaşabileceğiniz Durumlar** :bangbang:

1. 🚨 **Gradle kısmı built edilmiyorsa**  📍 File->Sync Projects  with Gradle files seçeneğine tıklayın
   
      <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Firebase%20ba%C4%9Flant%C4%B1s%C4%B1/Sync%20Grandle.gif" height="300">

</br>

2. 🚨 <project>build.gradle içerisine `allprojects` **eklemenize izin vermiyorsa**  📍 settings.gradle içerisindeki repositoriesMode ayarının `repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)` şeklinde ayarlayın.

  
#### Firebase Authentication işlemleri
  
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
  
📌 Çıkış Yapma
```kotlin  
  auth.signOut()
```

## Yerel *(Local)* Veritabanı


## Kaynakça :card_file_box:

1. [Kotlin İle Android Mobil Uygulama Geliştirme İleri Seviye, Atıl Samancıoğlu](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-ileri-seviye-10359)
1. [Developer Guides | Android Developers](https://developer.android.com/guide)
2. [Firebase docs](https://firebase.google.com/docs?gclid=CjwKCAjwg5uZBhATEiwAhhRLHqsAsuiwESHGtqxBz9KNG5a2oD-aRbJTDKExD2bnCLMQb0TMejKg2RoChRMQAvD_BwE&gclsrc=aw.ds)

---


<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/AradaBir%C3%87alanTelefonum.gif" align="left" height="100">


## İletişim :telephone_receiver:

:e-mail:  softwaredeveloperarchive@gmail.com

:iphone: [@softwaredeveloperarchive](https://www.instagram.com/softwaredeveloperarchive/)
