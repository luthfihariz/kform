package luthfihariz.com.kform

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created by luthfihariz on 17/04/18.
 */
class TestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        submit.setOnClickListener {
            email.validate({ it.isValidEmail() }, "Not a valid email")
            fullname.validate({ it.minimum(3) }, "Minimum 3 characters")
            phoneNumber.validate({ it.between(8, 13) }, "Should more than 8 characters and less than 13 characters")
            password.validate({ it.minimum(6) && it.matchScheme(Scheme.ALPHA_NUMERIC) }, "Password should minimum 6 character and alpha numeric")
            confirmPassword.validate({ it == password.text.toString() }, "Should match with password")
            tilSample.validate({ it.maximum(10) }, "Should less than 10 characters")
        }

        etOffFocus.validateOffFocus({ it.maximum(8) }, "Maximum 8 characters")
        etSampleTyping.validateWhileTyping({ it.minimum(3) }, "Minimum 3 characters")
        tilSampleFocus.validateOffFocus({ it.between(3, 6) }, "Should more than 3 and less than 6 characters")
        tilSampleTyping.validateWhileTyping({ it.isValidEmail() }, "Not a valid email")
    }
}