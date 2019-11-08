package com.example.domain.models

import android.os.Parcel
import android.os.Parcelable

class CharacterDomainModel(
    val name: String, val image100x100: String?, val image270x200: String?,
    val description: String, val comics: List<Comics>): Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString().orEmpty(),
        parcel.createTypedArrayList(Comics).orEmpty()
    )


    class Comics(val name: String, val resourceURI: String): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().orEmpty(),
            parcel.readString().orEmpty()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(resourceURI)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Comics> {
            override fun createFromParcel(parcel: Parcel): Comics {
                return Comics(parcel)
            }

            override fun newArray(size: Int): Array<Comics?> {
                return arrayOfNulls(size)
            }
        }

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image100x100)
        parcel.writeString(image270x200)
        parcel.writeString(description)
        parcel.writeTypedList(comics)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterDomainModel> {
        override fun createFromParcel(parcel: Parcel): CharacterDomainModel {
            return CharacterDomainModel(parcel)
        }

        override fun newArray(size: Int): Array<CharacterDomainModel?> {
            return arrayOfNulls(size)
        }
    }
}
