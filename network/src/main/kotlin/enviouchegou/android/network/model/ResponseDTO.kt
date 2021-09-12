package enviouchegou.android.network.model

import com.google.gson.annotations.SerializedName

internal const val GENERIC_ERROR_MSG = "Ops, something went wrong"

abstract class ResponseDTO(
    @SerializedName("Message") override var message: String = GENERIC_ERROR_MSG,
    @SerializedName("IsSuccess") override var isSuccess: Boolean = true
) : ResponseValidation