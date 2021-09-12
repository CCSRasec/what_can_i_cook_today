package enviouchegou.android.network.helper

import android.annotation.SuppressLint
import android.content.Context

class AppContext {

    companion object {
        @SuppressLint("StaticFieldLeak")
        public var context: Context? = null
    }
}