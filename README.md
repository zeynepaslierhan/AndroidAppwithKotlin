<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Kotlin ile Android Uygulaması Geliştirme
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/busy-cute.gif" align="right">

Windows ortamında Kotlin ile Android geliştirdiğim için kurulumlar ve uygulamalar buna göre ayarlanmıştır.

Öncesinde programlama geçmişim olduğu için kotlin öğrenirken hatırlatıcı niteliğinde olacak notlar aldım. Dolayısıyla önceden programlama geçmişi olan biri için öğretici, kotlin bilen biri için hatırlatıcı niteliğe sahip not derlemesidir. Daha detaylı bilgiler için kaynakça bölümünden çalıştığım yerlere bakabilirsiniz. 


## İçindekiler

1. Kurulum :wrench:
1. Kotlin Temelleri
1. Android Temelleri
1. Veritabanı İşlemleri
1.1. Bulut Bilişim (Cloud) kullanımı
1.2. Yerel (Local) Veritabanı
1. Kaynakça :card_file_box:

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


## Veritabanı İşlemleri

### Bulut Bilişim (Cloud) İşlemleri

#### Firebase



<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/%C4%B0%C5%9FimBittiSanm%C4%B1%C5%9F%C4%B1md%C4%B1r.gif" align="right">

## Kaynakça :card_file_box:

1. [Kotlin İle Android Mobil Uygulama Geliştirme Eğitimi Temel Seviye , Atıl Samancıoğlu, *BTK Akademi*](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274)
1. [Kotlin Tutorial](https://www.w3schools.com/KOTLIN/index.php)


---

## İletişim :telephone_receiver:

:e-mail:  softwaredeveloperarchive@gmail.com

:iphone: [@softwaredeveloperarchive](https://www.instagram.com/softwaredeveloperarchive/)
