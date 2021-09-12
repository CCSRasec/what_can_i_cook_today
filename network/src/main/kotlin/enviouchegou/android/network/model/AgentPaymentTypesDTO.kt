package enviouchegou.android.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AgentPaymentTypesDTO(
    @SerializedName("Tag") val tag: String,
    @SerializedName("Active") val active: Boolean,
) : Parcelable