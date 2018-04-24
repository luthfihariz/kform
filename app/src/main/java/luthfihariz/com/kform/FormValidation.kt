package luthfihariz.com.kform

import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
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
    error = if (validator(editText!!.text.toString())) {
        null
    } else {
        errorMessage
    }
}

fun EditText.validateOffFocus(validator: (String) -> Boolean, errorMessage: String, errorView: TextView? = null) {
    setOnFocusChangeListener { _, isFocus ->
        if (!isFocus) {
            validate(validator, errorMessage, errorView)
        }
    }
}

fun EditText.validateWhileTyping(validator: (String) -> Boolean, errorMessage: String, errorView: TextView? = null) {
    afterTextChanged {
        validate(validator, errorMessage, errorView)
    }
}

fun TextInputLayout.validateWhileTyping(validator: (String) -> Boolean, errorMessage: String) {
    editText?.validateWhileTyping(validator, errorMessage)
}

fun TextInputLayout.validateOffFocus(validator: (String) -> Boolean, errorMessage: String) {
    editText?.validateOffFocus(validator, errorMessage)
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
    const val ALPHA_NUMERIC = "[a-zA-Z0-9]"
    const val ALPHA_MIXED_CASE = "[a-zA-Z]"
    const val NUMERIC = "[0-9]"
    const val ALPHA_NUMERIC_MIXED_CASE = ""
}

fun String.matchScheme(scheme: String) = matches(Regex(scheme))

