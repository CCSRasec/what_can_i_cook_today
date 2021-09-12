import enviouchegou.android.network.BuildConfig
import enviouchegou.android.network.session.SessionManager.getAcceptLanguage
import enviouchegou.android.network.session.SessionManager.getBearerToken
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AgentInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val request: Request = original.newBuilder()
                .header("ApiKey", BuildConfig.API_KEY)
                .header("ApiPassword", BuildConfig.API_PASSWORD)
                .header("Authorization", getBearerToken())
                .header("accept-language", getAcceptLanguage())
                .method(original.method, original.body)
                .build()
        return chain.proceed(request)
    }
}