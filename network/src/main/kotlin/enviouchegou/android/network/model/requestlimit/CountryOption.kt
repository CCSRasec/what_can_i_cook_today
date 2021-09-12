package enviouchegou.android.network.model.requestlimit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CountryOption (
    @SerializedName("SourceCountry") var sourceCountry: String,
    @SerializedName("Option") var option: List<Option>
): Serializable
