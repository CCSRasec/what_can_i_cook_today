package enviouchegou.android.network

import com.google.gson.Gson
import enviouchegou.android.network.ui.UiStateLiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkIpClient {

    fun <T> getApi(service: Class<T>) =
        buildRetrofit(buildOkHttpClient())
            .create(service)

    private fun buildRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.IP_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(UiStateLiveDataCallAdapterFactory(true))
            .build()

    private fun buildOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(getHttpLoggingInterceptor())
            .build()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}