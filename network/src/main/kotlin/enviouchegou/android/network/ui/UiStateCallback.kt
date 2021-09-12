package enviouchegou.android.network.ui

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonSyntaxException
import enviouchegou.android.network.model.GENERIC_ERROR_MSG
import enviouchegou.android.network.model.ResponseDTO
import enviouchegou.android.network.model.ResponseValidation
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response


//TODO - Update this to validate Api error By response code after Update
@Suppress("UNCHECKED_CAST")
class UiStateCallback<R>(
    private val mutableLiveData: MutableLiveData<UiState<R>>,
    private val ignoreIsSuccessInBody: Boolean,
) :
    RetryCallback<R>() {

    override fun onRetry() {
        mutableLiveData.postValue(UiLoading)
    }

    override fun onFailure(call: Call<R>, t: Throwable) {
        super.onFailure(call, t)
        mutableLiveData.postValue(UiError(ErrorData(GENERIC_ERROR_MSG)))
    }

    override fun onResponse(call: Call<R>, response: Response<R>) {
        super.onResponse(call, response)

        val uiState = createUiState(response)

        mutableLiveData.postValue(uiState)
    }

    private fun createUiState(response: Response<R>): UiState<R> {
        val defaultResponse = getDefaultResponse(response.body()) ?: object : ResponseDTO() {}

        //Used by ip api
        if(ignoreIsSuccessInBody)
            defaultResponse.isSuccess = true

        return if (response.isSuccessful && defaultResponse.isSuccess) {
            createSuccessResponse(response)
        } else {
            val jObjError = JSONObject(response.errorBody()?.string())
            val error = jObjError.getString("Message")
            UiError(ErrorData(error.toString()))
        }
    }

    private fun createSuccessResponse(response: Response<R>): UiState<R> {
        val body = response.body()

        return if (body != null)
            UiSuccess(body)
        else
            UiSuccess(Unit as R)
    }

    private fun getDefaultResponse(body: R?): ResponseValidation? {
        body?.let {
            return try {
                body as ResponseValidation
            } catch (jsonSyntaxException: JsonSyntaxException) {
                null
            }
        } ?: return null
    }
}