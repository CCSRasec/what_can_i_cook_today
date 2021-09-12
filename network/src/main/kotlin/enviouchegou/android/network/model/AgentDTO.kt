package enviouchegou.android.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AgentDTO(
    @SerializedName("Notices") val Notices: List<NoticesDTO>,
    @SerializedName("PaymentTypes") val paymentTypes: List<AgentPaymentTypesDTO>,
    val Address: String,
    val Address2: String,
    val AgentId: Int,
    val AgentKey: String,
    val City: String,
    val ContactFax: String,
    val ContactPerson: String,
    val ContactPhone: String,
    val Country: String,
    val Email: String,
    val Name: String,
    val OpeningHours: String,
    val State: String,
    val Zip: String
) : Parcelable