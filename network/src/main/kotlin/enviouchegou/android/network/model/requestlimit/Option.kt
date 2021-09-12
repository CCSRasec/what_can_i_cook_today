package enviouchegou.android.network.model.requestlimit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Option(
    @SerializedName("Text") var text: String,
    @SerializedName("RequiredExtraInformation") var requiredExtraInfo: Boolean,
    @SerializedName("AdditionalInfo") var additionalInfo: List<AdditionalInfo>
):Serializable
