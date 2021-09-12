package enviouchegou.android.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserProfileDTO(
    @SerializedName("Id") val id: Long,
    @SerializedName("Email") val email: String,
    @SerializedName("Phone") val phone: String,
    @SerializedName("UserName") val username: String,
    @SerializedName("Fname") val firstName: String,
    @SerializedName("Lname") val lastName: String?,
    @SerializedName("IsAmbassador") val isAmbassador: Boolean,
    @SerializedName("IsBusinessUser") val isBusinessUser: Boolean,
    @SerializedName("IsFeeZero") val isFeeZero: Boolean,
    @SerializedName("ForcePasswordChange") val forcePasswordChange: Boolean,
    @SerializedName("IsCpfSsnRequired") val isCpfSsnRequired: Boolean,
    @SerializedName("SourceCountryCode") val sourceCountryCode: Int,
    @SerializedName("IsMarketingPromoAllowed") val isMarketingAllowed: Boolean?,
    @SerializedName("AgentDetails") val agent: AgentDTO,
    @SerializedName("Token") var accesstoken: String,
    @SerializedName("IsIncompleteProfile") var isIncompleteProfile: Boolean,

    ) : Parcelable {
    fun getFullName(): String {
        val first = firstName
        val last = lastName

        return "$first $last"
    }

    fun getFullNameOld() = "${this.firstName} ${this.lastName}"

    operator fun not(): Boolean {
        return true
    }
}