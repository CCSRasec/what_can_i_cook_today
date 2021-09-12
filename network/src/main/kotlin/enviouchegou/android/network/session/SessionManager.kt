package enviouchegou.android.network.session

import android.content.Context
import android.content.SharedPreferences
import com.orhanobut.hawk.Hawk
import enviouchegou.android.network.helper.AppContext.Companion.context
import enviouchegou.android.network.model.LoginResponseDTO
import enviouchegou.android.network.model.UserProfileDTO
import org.koin.android.BuildConfig
import java.util.*


object SessionManager {
    private const val USER_COMPLETE = "SESSION_USER"
    private const val DEFAULT_USER = "DEFAULT_USER"
    private const val USER_EXTERNAL_IP = "USER_EXTERNAL_IP"
    private const val TRANSFER = "TRANSFER"
    private const val PAGE = "PAGE"
    const val USER_PROFILE = "USER_PROFILE"
    const val PROMOCODE = "PROMOCODE"
    const val TOKEN = "DEVICE_TOKEN"

    fun initUserSession(loginResponseDTO: LoginResponseDTO, completeRegister: Boolean = false) {
        saveCustomValue(
            USER_COMPLETE,
            loginResponseDTO
        )
    }

    fun getUser(): LoginResponseDTO {
        return if (getCustomValue<LoginResponseDTO?>(
                USER_COMPLETE
            ) != null
        ) {
            getCustomValue<LoginResponseDTO>(
                USER_COMPLETE
            )
        } else {
            throw AuthException()
        }
    }

    fun getDefaultUser(): UserProfileDTO {
        return if (getCustomValue<UserProfileDTO?>(
                DEFAULT_USER
            ) != null
        ) {
            getCustomValue<UserProfileDTO>(
                DEFAULT_USER
            )
        } else {
            throw AuthException()
        }
    }

    fun saveDefaultUser(userProfile: UserProfileDTO) {
        saveCustomValue(
            DEFAULT_USER,
            userProfile
        )
    }

    fun saveExternalIp(ip: String) {
        saveCustomValue(
            USER_EXTERNAL_IP,
            ip
        )
    }

    fun savePage(page: Int) {
        saveCustomValue(
            PAGE,
            page
        )
    }

    fun getPage(): Int {
        return getCustomValue(
            PAGE
        )
    }

    fun getIp(): String {
        return getCustomValue<String>(
            USER_EXTERNAL_IP
        ) ?: ""
    }

    fun getAccessToken(): String {
        return if (getCustomValue<UserProfileDTO?>(
                DEFAULT_USER
            ) != null
        ) {
            getCustomValue<UserProfileDTO>(
                DEFAULT_USER
            ).accesstoken
        } else {
            throw AuthException()
        }
    }

    fun getBearerToken(): String {
        var token = ""
        try {
            token = getUser().userProfile.accesstoken
        } catch (e: AuthException) {
            return ""
        }
        return "Bearer $token"
    }

    fun getAcceptLanguage(): String {
        return try {
            Locale.getDefault().language
        } catch (e: Exception) {
            return "en"
        }
    }

    fun getAccessToken(sourceCountryCode: Int): String {
        return getUser().userProfile.accesstoken
    }

    fun hasTokenForCountry(sourceCountryCode: Int): Boolean {
        return false
    }

    fun userHasOnlyTokenForCountry(sourceCountryCode: Int): Boolean {
        return false
    }

    fun getWalletAccessToken(): String {
        return getUser().userProfile
            .accesstoken
    }

    fun getWalletCountryCode(): Int {
        return getUser().userProfile
            .sourceCountryCode
    }

    fun getSourceCountryCode(): Int {
        return getCustomValue<UserProfileDTO>(
            DEFAULT_USER
        ).sourceCountryCode
    }

    fun getPromocode(): String {
        return getCustomValue<String?>(PROMOCODE) ?: ""
    }

    fun isUserLoggedIn() = Hawk.contains(USER_COMPLETE)

    fun userHasWallet(): Boolean {
//        getUser().userProfile.forEach {
//            if (!it.walletDetail.isNullOrEmpty())
//                return true;
//        }

        return false
    }

    fun logOut() {
        Hawk.delete(USER_COMPLETE)
        Hawk.delete(DEFAULT_USER)
        Hawk.delete(USER_EXTERNAL_IP)
        Hawk.delete(USER_PROFILE)
    }

    fun <T> saveCustomValue(key: String, value: T) {
        Hawk.put(key, value)
    }

    fun <T> getCustomValue(key: String) =
        Hawk.get<T>(key)

    fun deleteCustomValue(key: String) =
        Hawk.delete(key)


    fun setDeviceToken(token: String) {
        saveCustomValue(TOKEN, token)
    }

    fun getDeviceToken(): String? {
        return getCustomValue(TOKEN)
    }
}
