package enviouchegou.android.network.model.requestlimit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AdditionalInfo(
    @SerializedName("Text") var textAdditionalInfo: String,
    @SerializedName("Type") var typeAdditionalInfo: String
):Serializable
