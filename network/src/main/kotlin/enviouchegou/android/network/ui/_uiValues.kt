package enviouchegou.android.network.ui

import android.content.Context
import java.util.*

fun translatedString(message: String, context: Context): String {
    val replacedMessage = message
        .trim()
        .toLowerCase(Locale.getDefault())
        .replace(" ", "_")
        .replace("[^A-Za-z0-9_]".toRegex(), "")
        .replaceFirst("^\\d".toRegex(), "")

    val strResource =
        context.resources?.getIdentifier(replacedMessage, "string", context.packageName);

    var translatedMessage = message

    if (strResource != null && strResource > 0) {
        translatedMessage = context.resources.getString(strResource)
    }

    return translatedMessage
}