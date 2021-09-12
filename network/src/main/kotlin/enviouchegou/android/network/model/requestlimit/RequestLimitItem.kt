package enviouchegou.android.network.model.requestlimit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RequestLimitItem (
    @SerializedName("UpperLimit") val upperLimit: String,
    @SerializedName("LimitRequest") val limitRequest: List<LimitRequestDetail>
) : Serializable
