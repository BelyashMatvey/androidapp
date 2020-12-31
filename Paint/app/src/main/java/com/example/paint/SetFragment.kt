package com.example.paint
import android.app.Activity.RESULT_OK
import android.content.Intent
//import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.paint.R
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
/*class SetFragment{
    private fun initFields(){
        constraintLayout.settings_change_photo.setOnClickListener{changePhotoUser()}
    }
    private fun changePhotoUser(){
        CropImage.activity()
                .setAspectRatio(1,1)
                .setRequestedSize(600,600)
                .start(this as MainActivity)
    }
    fun onActivityResult(requestCode:Int,resultCode:Int,data:Intent?){
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE&&resultCode==RESULT_OK&&data!=null){
            val uri=CropImage.getActivityResult(data).uri
        }
    }
}*/