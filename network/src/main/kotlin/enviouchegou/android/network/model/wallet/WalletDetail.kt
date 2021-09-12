package enviouchegou.android.network.model.wallet

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WalletDetail (
    @SerializedName("ClientId") val clientId: String,
    @SerializedName("AccountId") val accountId: String,
    @SerializedName("Currency") val currency: String
) : Serializable
