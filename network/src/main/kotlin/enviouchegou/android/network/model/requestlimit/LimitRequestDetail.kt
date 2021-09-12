package enviouchegou.android.network.model.requestlimit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LimitRequestDetail (
    @SerializedName("FieldName") var fieldName: String,
    @SerializedName("FieldKey") var fieldKey: String,
    @SerializedName("FieldType") var fieldType: String,
    @SerializedName("LimitUpto") var limitUpto: String,
    @SerializedName("FieldDescription") var fieldDescription: String,
    @SerializedName("MaxLength") var maxLength: Int,
    @SerializedName("MinLength") var minLength: Int,
    @SerializedName("CountryNameOption") var countryOption: List<CountryOption>
): Serializable