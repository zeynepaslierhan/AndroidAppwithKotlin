<h1 align="center">
  <br>
  <a href="https://github.com/zeynepaslierhan/.NetCoreArchive"><img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/Logo.png" alt="SoftwareDeveloperArchive" width="200"></a>
  <br>
  Super Hero Book
  <br>
</h1>

<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/BanaBenziyor.gif" align="right">

Recycle View Çalışması için yapılmış, başlangıç seviyesinde android uygulama geliştirme projesidir. [Atıl Samancıoğlu'nun BTK akademi'de verdiği eğitimdeki](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274) proje baz alınarak çalışılmıştır.

## Recycle View Nedir?

RecyclerView; verilerin adapter kullanılarak listelenmesini sağlar.

RecyclerView, ListView gibi uygulama ayağa kalktığında tüm verileri ekrana çizerek listeleme yapmaz. RecyclerView listenin ekrana sığacak kadar elemanını ekrana çizer. 

## Recycle View Nasıl Kullanılır?

> :rotating_light: **NOT:** `id 'kotlin-android-extensions'` kod satırının build.gradle içerisindeki plungins'de olduğundan ve sonrasında `import kotlinx.android.synthetic.main....` kütüphanesi eklediğinizde bir sıkıntı olmadığından emin olun. :bangbang:

1. activity_main.xml dosyasına Recycle View eklenip id değeri verildi.
   
   ```kotlin
   android:id="@+id/textViewRecycler"
   ```   

2. Recycle View içerisinde kullanılacak veriler hazırlandı:
   
   ```kotlin

   //String türünde veriler tanımlanacak bir dizi superHeros değişkenine tanımlandı.
   var superHeros = ArrayList<String>()

   //superHeros içerisine kullanıcak veriler eklendi:

   superHeros.add("Batman")
   superHeros.add("Superman")
   superHeros.add("Iron man")
   ```
3. Süper kahramanlara ait görsellerin kullanımı:

    1. **Yöntem:** Bitmap
   
        Bitmap, bir nokta matrisinden oluşan bir dijital görüntüdür. `BitmapFactory` varolan görselleri kod içinde bitmap türünde tanımlamızı sağlar.

        > Varolan görsellerin kaynağına ulaşırken `applicationContext.resources` kullanılır.

        ```kotlin
        
        // Varolan görsellerin bitmap türünde veriler olarak tutulması

        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)

        // Oluşturulan verilerin diziye atılması

        var superHerosImgs = ArrayList<Bitmap>()

        superHerosImgs.add(batmanBitmap)
        superHerosImgs.add(supermanBitmap)
        superHerosImgs.add(ironmanBitmap)

        ```

    2. **Yöntem** Dosya dizinin kullanılması

4. RecycleView işlemleri

    📌 Recycle View içerisinde kullanılacak olan xml dosyasının 📍 **layout klasörü** içerisinde oluşturulması:

    ```xml

      <?xml version="1.0" encoding="utf-8"?>
      <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
      >

        <TextView
            android:id="@+id/recyclerViewText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:text="Deneme"
            >

        </TextView>
      </LinearLayout>
    ```

    📌 xml dosyası ile ana dosyaları birbirine bağlayan Adapter sınıfının oluşturulması:

    > **Recycler Adapter:** 

    1.  📍 **Java/com.zeynepaslierhan.superherobook** klasörü içerisine kotlin sınıfı oluşturulur.
    2.  Oluşturulan sınıf aşağıdaki şekilde düzenlenir:

    ```kotlin
    class RecyclerAdapter(val superHerosList: ArrayList<String>,val superHerosImgs: ArrayList<Bitmap>) : RecyclerView.Adapter<RecyclerAdapter.SuperHerosVH>() {
      class SuperHerosVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

      }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHerosVH {
          val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_row,parent,false)
          return SuperHerosVH(itemView)
      }

      override fun onBindViewHolder(holder: SuperHerosVH, position: Int) {
          holder.itemView.recyclerTextView.text = superHerosList.get(position)
      }

      override fun getItemCount(): Int {
          return superHerosList.size
      }
    }
    ```

5. MainActivity içerisine gerekli kod satırları eklendi:

    ```kotlin

    // gerekli kütüphaneler:
    import android.support.v7.widget.LinearLayoutManager
    import kotlinx.android.synthetic.main.activity_main.*

    // Kodlar:
    val layoutManager = LinearLayoutManager(this)
    textViewRecycler.layoutManager = layoutManager
    
    val adapter = RecyclerAdapter(superHeros,superHerosImgs)
    textViewRecycler.adapter = adapter
    ```


<img src="https://github.com/zeynepaslierhan/zeynepaslierhan/blob/main/img/gifs/%C4%B0%C5%9FimBittiSanm%C4%B1%C5%9F%C4%B1md%C4%B1r.gif" align="right">

## Kaynakça :card_file_box:

1. [Kotlin İle Android Mobil Uygulama Geliştirme Eğitimi Temel Seviye , Atıl Samancıoğlu, *BTK Akademi*](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274)
2. [Developer Guides | Android Developers](https://developer.android.com/guide)

---

## İletişim :telephone_receiver:

:e-mail:  softwaredeveloperarchive@gmail.com

:iphone: [@softwaredeveloperarchive](https://www.instagram.com/softwaredeveloperarchive/)