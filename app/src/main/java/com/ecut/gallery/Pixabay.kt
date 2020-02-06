package com.ecut.gallery

import com.google.gson.annotations.SerializedName

data class Pixabay(
    val totalHits:Int,
    val hits:Array<PhotoItem>,
    val total:Int
    ){

}

data class PhotoItem(
    @SerializedName ("webformatURL") val previewUrl :String,
    @SerializedName("id") val photoId:Int,
    @SerializedName("largeImageURl") val fullUrl :String

)