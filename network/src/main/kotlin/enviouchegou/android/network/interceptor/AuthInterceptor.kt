package enviouchegou.android.network.interceptor

import com.google.gson.Gson
import enviouchegou.android.network.model.ResponseValidationDTO
import enviouchegou.android.network.session.AuthException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

internal class AuthInterceptor : Interceptor {

    private companion object {
        const val INVALID_TOKEN = "Invalid access token"
        const val EXPIRED_TOKEN = "Token expired"
        const val TOKEN_INVALID = "Invalid Token"
        const val CODE_RETURN_UNAUTHORIZED = 401
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = response.body
        val bodyString = body?.string()
        val codeReturn = response.code

        if (hasInvalidToken(codeReturn)) {
            throw AuthException()
        }

        val newBody = bodyString?.toResponseBody(body.contentType())

        return response.newBuilder()
            .body(newBody)
            .build()
    }

    private fun hasInvalidToken(codeReturn: Int?) =
        codeReturn != null && validateKeys(codeReturn)

    private fun validateKeys(codeReturn: Int): Boolean =
        CODE_RETURN_UNAUTHORIZED == codeReturn

    private fun getResponse(responseBody: String): ResponseValidationDTO {
        return try {
            Gson().fromJson<ResponseValidationDTO>(
                responseBody,
                ResponseValidationDTO::class.java
            )
        } catch (e: Exception) {
            ResponseValidationDTO("", false)
        }
    }
}