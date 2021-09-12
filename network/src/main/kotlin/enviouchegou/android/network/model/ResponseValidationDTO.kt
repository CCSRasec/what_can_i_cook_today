package enviouchegou.android.network.model

import com.google.gson.annotations.SerializedName

//TODO - Change this -> Update UiState and models to use only one model to validate service rules
class ResponseValidationDTO(
    @SerializedName("Message") var message: String,
    @SerializedName("IsSuccess") var isSuccess: Boolean
)