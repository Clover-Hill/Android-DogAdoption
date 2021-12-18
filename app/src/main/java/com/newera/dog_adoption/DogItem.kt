package com.newera.dog_adoption

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogItem(
    var id : Int = 0,
    var name : String = "Henry",
    var age : Int = 10,
    var description : String? = "A very nice and loveable puppy."
): Parcelable
