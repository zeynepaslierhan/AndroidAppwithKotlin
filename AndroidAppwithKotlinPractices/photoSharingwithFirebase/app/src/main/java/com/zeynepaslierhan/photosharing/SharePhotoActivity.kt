
package com.zeynepaslierhan.photosharing

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_share_photo.*
import java.util.UUID

class SharePhotoActivity : AppCompatActivity() {

    var chosenImg : Uri?=null
    var chosenBitmap : Bitmap?=null

    private lateinit var storage: FirebaseStorage
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_photo)
        storage = FirebaseStorage.getInstance()
        auth= FirebaseAuth.getInstance()
        database= FirebaseFirestore.getInstance()
    }

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

    fun SelectImg(view:View) {
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }else{
            val ımages = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(ımages,2)
        }
    }

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
}