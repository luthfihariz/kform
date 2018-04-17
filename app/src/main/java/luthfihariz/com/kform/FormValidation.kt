package luthfihariz.com.kform

import android.util.Patterns
import android.widget.EditText

/**
 * Created by luthfihariz on 17/04/18.
 */

fun EditText.validate(validator: (String) -> Boolean, message: String) {
    if (!validator(text.toString())) {
        error = message
    }
}

fun String.isValidEmail() = isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.between(min: Int, max: Int) = isNotEmpty() && length >= min && length <= max

fun String.maximum(max: Int) = isNotEmpty() && length <= max

fun String.minimum(min: Int) = isNotEmpty() && length >= min

object Scheme {
    const val ALPHA_NUMERIC = ""
    const val ALPHA_MIXED_CASE = ""
    const val NUMERIC = ""
}

fun String.matchScheme(scheme: String) = matches(Regex(scheme))

