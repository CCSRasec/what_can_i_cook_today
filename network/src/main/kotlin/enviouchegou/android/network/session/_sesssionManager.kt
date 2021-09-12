package enviouchegou.android.network.session

import enviouchegou.android.network.model.UserProfileDTO
import enviouchegou.android.network.session.SessionManager.PROMOCODE

private const val USER_PHONE = "USER_PHONE"
private const val USER_PASSWORD = "USER_PASSWORD"
private const val USER_COUNTRY_CODE = "USER_COUNTRY_CODE"
private const val USER_DIAL_CODE = "USER_DIAL_CODE"

fun saveDefaultUser(defaultUser: UserProfileDTO) {
    SessionManager.saveDefaultUser(defaultUser)
}

fun saveNewDefaultSource(countryId: Int) {
    SessionManager.getUser().userProfile
}

fun hasToken(countryId: Int) =
    SessionManager.getUser().userProfile.sourceCountryCode > 0

fun getTokenFromSourceCountry(countryId: Int) =
    SessionManager.getUser().userProfile.sourceCountryCode

fun saveCredentials(phone: String, password: String, sourceCountryCode: Int, dialCode: Int) {
    SessionManager.saveCustomValue(USER_PHONE, phone)
    SessionManager.saveCustomValue(USER_PASSWORD, password)
    SessionManager.saveCustomValue(USER_COUNTRY_CODE, sourceCountryCode)
    SessionManager.saveCustomValue(USER_DIAL_CODE, dialCode)
}

fun savePromocode(promocode: String) {
    SessionManager.saveCustomValue(PROMOCODE, promocode)
}

fun getPhoneUser() =
    SessionManager.getCustomValue<String>(USER_PHONE) ?: ""

fun getPasswordUser() =
    SessionManager.getCustomValue<String>(USER_PASSWORD) ?: ""

fun getSourceCountryCodeUser() =
    SessionManager.getCustomValue<Int>(USER_COUNTRY_CODE) ?: 1

fun getDialCodeUser() =
    SessionManager.getCustomValue<Int>(USER_DIAL_CODE) ?: 1

