<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Temel Bilgiler
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/busy-cute.gif" align="right">

## İçindekiler

1. [Kurulum :wrench:](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#wrench-kurulum)

	1. [JDK](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#jdk)
	2. [Android Studio](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#android-studio)
 
2. [Kotlin Temelleri](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#kotlin-temelleri)

	1. [Giriş](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#giri%C5%9F)
	2. [Kotlin NYP Yapısı](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#kotlin-nyp-yap%C4%B1s%C4%B1)
 
3. [Android Temelleri](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#android-temelleri)

	1. [Kütüphaneler](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#k%C3%BCt%C3%BCphaneler)
	2. [Çerçeveler *(Frameworks)*](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#%C3%A7er%C3%A7eveler-framework)
	3. [Bileşenler](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#bile%C5%9Fenler)
		
		1. [Ek Bileşenler](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#ek-bile%C5%9Fenler)

4. [Android Studio](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#android-studio-1)
	
	1. [Klasör Yapısı](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#klas%C3%B6r-yap%C4%B1s%C4%B1)

5. [Kaynakça :card_file_box:](https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/Temel%20Bilgiler.md#kaynak%C3%A7a-card_file_box)

## :wrench: Kurulum

### JDK

1. [Oracle Java Technologies | Oracle](https://www.oracle.com/java/technologies/) sayfasından JDK indirilir.

1. JDK indirildikten sonra kurulumu yapılır. 

2. JDK kurulumu olduktan sonra java çalıştığı exe dosyasının path’i alınır. Bunun için java’nın kurulduğu klasörde “java.exe” dosyası aranır. Örneğin benim dosya düzenime göre java.exe’nin path’i `C:\Program Files\Java\jdk-19\bin\java.exw`, dolayısıla bulunduğu klasör → `C:\Program Files\Java\jdk-19\bin`
    
   
    
3. Bilgisayarın java.exe’yi çalıştırması için hangi konumda olduğunu bilmesi gerekiyor. Bunun için java.exe’nin olduğu klasörün path’i aşağıdaki konuma eklenir: 
    
    :round_pushpin: Bilgisayar özellikleri → Gelişmiş seçenekler → Çevresel Değişkenler → Sistem değişkenleri → Path
    
    
    
### Android Studio

1. [Android Studio sayfasından](https://developer.android.com/studio) indirilir.
    
   
    
2. İndirilen dosya kurulur.
    
   
    
3. Android Studio kurulumundan sonra benim yaptığım ayarlar:
    
    
## Kotlin Temelleri

### Giriş

📌 Fonksiyonlar `fun xxx()`

📌 Değişkenler

- `var` , `val` farklı veri tiplerini barındırabilen değişkenlerdir.  

  > `val` ile tanımlanan değişkenlerin değeri sonradan değiştirilemez.

📌 Veri tipleri : 

- Integer türleri  : `Byte`, `Short`, `Int` ,`Long`
- Float türleri: `Double` ,`Float`
- Yazı türleri: `Char`,`String`
- Dizi (Array) türleri :`ArrayList<>`,`arrayListOf()` ,`HashOf<>`,`hashMapOf<,>`,`setOf<>`, `arrayOf()`
    
    > String türündeki bir değişken, char veri tipi barındıran bir string olarak düşünülebilir.
    > 

📌 Veri tipleri arasında dönüştürme işlemi (Casting):

```kotlin
val int_value = 10
val long_value = int_value.toLong()
```

### Kotlin NYP Yapısı

Nesneye Yönelik Programlama hakkında daha detaylı bilgi edinmek için…

📌 Sınıf (Class) yapısı oluşturulması:

```kotlin
class Car {
  var brand = ""
  var model = ""
  var year = 0
}
```

📌 İlgili sınıf için bir nesne yaratılması:

```kotlin
// c1, Car sınıfından oluşturulmuş bir nesnesin referansıdır.
val c1 = Car()

//c1 referansının tuttuğu nesnenin özelliklerine erişmek için:
c1.brand = "Ford"
c1.model = "Mustang"
c1.year = 1969
```

📌 Yapıcı methodlar ile parametre şeklinde sınıf yapısının özelliklerini tanımlayabilirsiniz.

```kotlin
// 1. kullanım şekli
class Car {
  var brand = ""
  var model = ""
  var year = 0

	contructor(brand : String,model :String,year : Int){
		this.brand = brand
		this.model = model 
		this.year = year 
	}
}

// 2. kullanım şekli
class Car(var brand: String, var model: String, var year: Int)

fun main() {
  val c1 = Car("Ford", "Mustang", 1969)
}
```

📌 Sınıflara ait methodlar tanımlamak için:

```kotlin
// Car sınıfına ait drive methodu
class Car(var brand: String, var model: String, var year: Int) {
  // Class function
  fun drive() {
    println("Wrooom!")
  }
}

// Car sınıfından üretilmiş bir nesneyle drive methoduna ulaşma

fun main() {
  val c1 = Car("Ford", "Mustang", 1969)
  
  // Call the function
  c1.drive()
}
```

📌 Sınıfların başka bir sınıftan kalıtım alması için:

```kotlin
// Kalıtım alınan sınıf : superclass, parent
open class MyParentClass {
  val x = 5
}

// Kalıtım alan  sınıf: subclass, child
class MyChildClass: MyParentClass() {
  fun myFunction() {
    println(x) // x is now inherited from the superclass
  }
}

// Create an object of MyChildClass and call myFunction
fun main() {
  val myObj = MyChildClass()
  myObj.myFunction()
}

// OUTPUT : 5
```

## Android Temelleri

Android; mobil cihazlar için açık kaynaklı ve Linux tabanlı bir işletim sistemidir. Dalvik Virtual Machine sayesinde android için yazılmış uygulamalar yürütülür

### Kütüphaneler

**android.app** - Uygulama modeline erişim sağlar ve tüm Android uygulamalarının temelidir.

**android.content** - Uygulamalar ve uygulama bileşenleri arasında içerik erişimini, yayınlamayı ve mesajlaşmayı sağlar.

**android.database** – SQLite veritabanı yönetim sınıflarını içerir.

**android.opengl** - OpenGL ES 3B grafik işleme API'sine yönelik bir Java arabirimi.

**android.os** - Uygulamalara, mesajlar, sistem hizmetleri ve süreçler arası iletişim dahil olmak üzere standart işletim sistemi hizmetlerine erişim sağlar.

**android.text** - Bir cihaz ekranındaki metni işlemek ve değiştirmek için kullanılır.

**android.view** - Uygulama kullanıcı arayüzlerinin temelidir

**android.widget** - Düğmeler, etiketler, liste görünümleri, düzen yöneticileri, radyo düğmeleri vb. gibi önceden oluşturulmuş kullanıcı arayüzü bileşenlerinden oluşur.

**android.webkit** - Web'de gezinme yeteneklerinin uygulamalara yerleştirilmesini sağlar.

### Çerçeveler (Framework)

**Activity Manager** - Uygulama yaşam döngüsünün ve etkinlik yığınının tüm yönlerini kontrol eder.

**Content Providers** - Uygulamaların diğer uygulamalarla veri yayınlamasına ve paylaşmasına izin verir.

**Resource Manager** - Dizeler, renk ayarları ve kullanıcı arabirimi düzenleri gibi kod içermeyen gömülü kaynaklara erişim sağlar.

**Notifications Manager** − Uygulamaların kullanıcıya uyarılar ve bildirimler görüntülemesine izin verir.

**View System** - Uygulama kullanıcı arabirimleri oluşturmak için kullanılan genişletilebilir bir görünüm kümesi.

### Bileşenler

-  📌 Aktiviteler *(Activities)*
    
    Kullanıcı arayüzü olan tek bir ekranda gerçekleşen işlemlerdir. 
    
    *Bir aktivite, Activity sınıfının bir alt sınıfı olarak aşağıdaki gibi uygulanır:*
    
    ```kotlin
    public class MainActivity extends Activity {
    }
    ```

    <img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Aktivite%20ya%C5%9Fan%20d%C3%B6ng%C3%BCs%C3%BC.png" alt="Aktiviteler">
    
- 📌 Servisler *(Services)*
    
    Arka planda çalışan ve çalışacak işlemleri yöneten yapılardır.
    
    > Android işletim sistemi, service class’lara, activity’lere göre öncelik tanır. Cihazın RAM sıkıntısı olduğu durumlarda önce activity’leri kapatır sonra servisleri otomatik kapatmaya başlar.
    > 
    
    İki adet servis türü vardır:
    
    1. Foreground Service : Bir arayüzü vardır. Örneğin: Facebook Messenger uygulamasını açıp arka planda başka bir uygulamaya girdiğinizde Messenger’dan size mesaj gelir ve bir baloncuk karşınıza çıkar. İşte bu da bir Foreground Servisdir.
    2. Background Service :  Bir post veya db işlemleri sırasında arka planda işleyen ve kullanıcıyı etkilemeyen servislerdir.
    
    Service yazarken 2 class kullanılır edilebilir:
    
    1. Intent Service Class: Main thread üzerinde değil de başka thread üzerinde işlem yapmamızı sağlar.
    2. Service Class: Main thread’in üzerinde çalışır.
    
    *Bir hizmet, aşağıdaki gibi Hizmet sınıfının bir alt sınıfı olarak uygulanır:*
    
    ```kotlin
    public class MyService extends Service {
    }
    ```
    
- 📌 Yayın Alıcılar *(Broadcast Receivers)*
    
    Android işletim sisteminde belli fonksiyonlar için bütün uygulamalara yayın yapan yapılardır. Yani işletim sistemi ile uygulamalar arasındaki iletişimi yönetirler.
    
    *Bir yayın alıcısı, BroadcastReceiver sınıfının bir alt sınıfı olarak uygulanır ve her mesaj bir Intent nesnesi olarak yayıncıdır:*
    
    ```kotlin
    public class MyReceiver  extends  BroadcastReceiver {
       public void onReceive(context,intent){}
    }
    ```
    
- 📌 İçerik sağlayıcılar *(Content Providers)*
    
    Veri ve veritabanı yönetiminden sorumludurlar.
    
    *Bir içerik sağlayıcı, ContentProvider sınıfının bir alt sınıfı olarak uygulanır ve diğer uygulamaların işlem gerçekleştirmesini sağlayan standart bir API kümesi uygulamalıdır:*
    
    ```kotlin
    public class MyContentProvider extends  ContentProvider {
       public void onCreate(){}
    }
    ```

#### Ek Bileşenler

- 📌 **Fragments**
    
    Activity içindeki kullanıcı arabiriminin bir bölümünü temsil eder.
    
- 📌 **Views**
    
    Düğmeler, listeler formları vb. dahil olmak üzere ekranda çizilen UI öğeleri.
    
- 📌 **Layouts**
    
    Views’lar arasındaki kontrolü sağlayan menü-panel.
    
- 📌 **Intents**
    
    Bileşenleri birbirine bağlayan mesajlar.
    
- 📌 **Resources**
    
    Dizeler, sabitler ve çekilebilir resimler gibi harici öğeler.
    
- 📌 **Manifest**
    
    Uygulama için  gerekli yapılandırma dosyası.
    

## Android Studio

### Klasör yapısı

<img src="https://github.com/zeynepaslierhan/AndroidAppwithKotlin/blob/main/img/Android%20klas%C3%B6r%20yap%C4%B1s%C4%B1.png" alt="Andoid Studio">

1. klasör, **Java** : Bu, projeniz için .java kaynak dosyalarını içerir. 
2. klasör, **res/drawable-hdpi**: Bu, yüksek yoğunluklu ekranlar için tasarlanmış çizilebilir nesneler içindir
3. klasör, **res/layout**: uygulamanızın kullanıcı arayüzünü tanımlayan dosyalar içindir.
4. klasör, **res/values**: dizeler ve renk tanımları gibi bir kaynak koleksiyonu içeren diğer çeşitli XML dosyaları için bir dizindir.
5. dosya **AndroidManifest.xml**: uygulamanın temel özelliklerini açıklayan ve bileşenlerinden her birini tanımlayan bildirim dosyasıdır.
6. dosya, **Build.gradle**: compileSdkVersion, buildToolsVersion, applicationId, minSdkVersion, targetSdkVersion, versionCode ve versionName içeren otomatik oluşturulmuş bir dosyadır.


<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/%C4%B0%C5%9FimBittiSanm%C4%B1%C5%9F%C4%B1md%C4%B1r.gif" align="right">

## Kaynakça :card_file_box:

1. [Kotlin İle Android Mobil Uygulama Geliştirme Eğitimi Temel Seviye , Atıl Samancıoğlu, *BTK Akademi*](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274)
1. [Kotlin Tutorial](https://www.w3schools.com/KOTLIN/index.php)
1. [Android Tutorial](https://www.tutorialspoint.com/android/index.htm)
1. [Nedir bu Android Service ve Broadcast Receiver](https://medium.com/kodluyoruz/nedir-bu-android-service-ve-broadcast-receiver-291168de075b)
1. [Developer Guides | Android Developers](https://developer.android.com/guide)

---

## İletişim :telephone_receiver:

:e-mail:  softwaredeveloperarchive@gmail.com

:iphone: [@softwaredeveloperarchive](https://www.instagram.com/softwaredeveloperarchive/)
