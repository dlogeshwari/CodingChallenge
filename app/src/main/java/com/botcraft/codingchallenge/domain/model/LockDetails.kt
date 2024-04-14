package com.botcraft.codingchallenge.domain.model

import ccom.botcraft.codingchallenge.domain.model.Range
import com.google.gson.annotations.SerializedName


class LockDetails() {

    @SerializedName("lockVoltage")
    var lockVoltage: LockVoltage? = LockVoltage()
    @SerializedName("lockType")
    var lockType: LockType? = LockType()
    @SerializedName("lockKick")
    var lockKick: LockKick? = LockKick()
    @SerializedName("lockRelease")
    var lockRelease: LockRelease? = LockRelease()
    @SerializedName("lockReleaseTime")
    var lockReleaseTime: LockReleaseTime? = LockReleaseTime()
    @SerializedName("lockAngle")
    var lockAngle: LockAngle? = LockAngle()

}

class LockAngle {

    @SerializedName("range")
    var range: Range? = Range()
    @SerializedName("unit")
    var unit: String? = null
    @SerializedName("default")
    var default: Int? = null
    @SerializedName("common")
    var common: Boolean? = null

}

class LockRelease  {

    @SerializedName("values")
    var values: ArrayList<String> = arrayListOf()
    @SerializedName("default")
    var default: String? = null
    @SerializedName("common")
    var common: Boolean? = null

}

class LockKick{

    @SerializedName("values")
    var values: ArrayList<String> = arrayListOf()
    @SerializedName("default")
    var default: String? = null

}

class LockType {

    @SerializedName("values")
    var values: ArrayList<String> = arrayListOf()
    @SerializedName("default")
    var default: String? = null

}

class LockVoltage {

    @SerializedName("values")
    var values: ArrayList<String> = arrayListOf()
    @SerializedName("default")
    var default: String? = null

}

class LockReleaseTime {

    @SerializedName("range")
    var range: Range? = Range()
    @SerializedName("unit")
    var unit: String? = null
    @SerializedName("default")
    var default: Double? = null

}
