package enviouchegou.android.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginResponseDTO(
    @SerializedName("Result") val userProfile: UserProfileDTO
) : Parcelable, ResponseDTO()
