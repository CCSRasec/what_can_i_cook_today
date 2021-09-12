package enviouchegou.android.network

import AgentInterceptor
import com.google.gson.Gson
import enviouchegou.android.network.interceptor.AuthInterceptor
import enviouchegou.android.network.ui.UiStateLiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    fun <T> getApi(service: Class<T>): T =
            buildRetrofit(buildOkHttpClient())
                    .create(service)

    fun <T> getApi(service: Class<T>, ignoreApiResponse: Boolean): T {
        return buildRetrofit(buildOkHttpClient(), ignoreApiResponse)
                .create(service)
    }

    private fun buildRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(UiStateLiveDataCallAdapterFactory())
                .build()
    }

    private fun buildRetrofit(okHttpClient: OkHttpClient, ignoreApiResponse: Boolean): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(UiStateLiveDataCallAdapterFactory(ignoreApiResponse))
                .build()
    }

    private fun buildOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(AgentInterceptor())
                .addInterceptor(AuthInterceptor())
                .addInterceptor(getHttpLoggingInterceptor())
                .build()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
}
