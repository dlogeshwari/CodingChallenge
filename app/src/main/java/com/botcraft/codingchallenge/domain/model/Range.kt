package ccom.botcraft.codingchallenge.domain.model
import com.google.gson.annotations.SerializedName


data class Range (

  @SerializedName("min" ) var min : Double? = null,
  @SerializedName("max" ) var max : Double? = null

)