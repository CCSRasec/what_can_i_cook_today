package enviouchegou.android.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoticesDTO(
    @SerializedName("Title") val title: String,
    @SerializedName("Description") val description: String,
    @SerializedName("IsDisplayed") val isDisplayed: Boolean
) : Parcelable