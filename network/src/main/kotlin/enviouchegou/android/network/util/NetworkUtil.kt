package enviouchegou.android.network.util

import enviouchegou.android.network.BuildConfig.*
import java.net.Inet4Address
import java.net.NetworkInterface


fun ipAddress(): String {
    try {
        val en = NetworkInterface
            .getNetworkInterfaces()
        while (en.hasMoreElements()) {
            val intf = en.nextElement()
            val enumIpAddr = intf.inetAddresses
            while (enumIpAddr.hasMoreElements()) {
                val inetAddress = enumIpAddr.nextElement()

                // for getting IPV4 format
                if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                    return inetAddress.getHostAddress()
                }
            }
        }
    } catch (ex: Exception) {
    }
    return ""
}

fun getApiKey(): String {
    val unfinishedKey = API_KEY.dropLast(1)
    return String.format("%s%s", unfinishedKey, "U")
}

fun getApiPassword(): String {
    val unfinishedPassword = API_PASSWORD.dropLast(1)
    return String.format("%s%s", unfinishedPassword, "7")
}

fun getGoogleKey(): String {
    return GOOGLE_KEY
}