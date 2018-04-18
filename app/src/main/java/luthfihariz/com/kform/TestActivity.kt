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
            email.validate({ s -> s.isValidEmail() }, "Not a valid email")
            fullname.validate({ s -> s.minimum(3) }, "Should contain 3 characters at minimum")
            phoneNumber.validate({ s -> s.between(8, 13) }, "Should min 8 and max 13")
            password.validate({
                it.minimum(6) && it.matchScheme(Scheme.ALPHA_NUMERIC)
            }, "Password should minimum 6 character and alpha numeric")
            confirmPassword.validate({ s -> s == password.text.toString() }, "Should match with password")

            tilSample.validate({ s -> s.maximum(10) }, "Should less than 10 characters")

            tilSample.let { }

            val isValid = tilSample.validate {
                it.maximum(15)
                it.isValidEmail()
            }
        }
    }
}