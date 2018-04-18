package luthfihariz.com.kform

import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView

/**
 * Created by luthfihariz on 17/04/18.
 */

fun EditText.validate(validator: (String) -> Boolean, errorMessage: String, errorView: TextView? = null) {
    val valid = validator(text.toString())
    if (!valid) {
        if (errorView != null) {
            errorView.text = errorMessage
        } else {
            error = errorMessage
        }
    }
}

fun TextInputLayout.validate(validator: (String) -> Boolean, errorMessage: String) {
    if (!validator(editText!!.toString())) {
        error = errorMessage
    }
}

fun TextInputLayout.validateWhileTyping(validator: (String) -> Boolean, errorMessage: String) {
    editText?.afterTextChanged {
        validate(validator, errorMessage)
    }
}

fun TextInputLayout.validateOutFocus(validator: (String) -> Boolean, errorMessage: String) {
    editText?.setOnFocusChangeListener { _, isFocus ->
        if (!isFocus) {
            validate(validator, errorMessage)
        }
    }
}

fun EditText.afterTextChanged(func: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            func.invoke(p0.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    })
}

fun String.isValidEmail() = isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.between(min: Int, max: Int) = isNotEmpty() && length >= min && length <= max

fun String.maximum(max: Int) = isNotEmpty() && length <= max

fun String.minimum(min: Int) = isNotEmpty() && length >= min

object Scheme {
    const val ALPHA_NUMERIC = ""
    const val ALPHA_MIXED_CASE = ""
    const val NUMERIC = ""
    const val ALPHA_NUMERIC_MIXED_CASE = ""
}

fun String.matchScheme(scheme: String) = matches(Regex(scheme))

