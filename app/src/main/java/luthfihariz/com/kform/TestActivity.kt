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
            fullname.validate({s -> s.minimum(3)}, "Should contain 3 characters at minimum")
            password.validate({ s -> s.minimum(6) && s.matchScheme(Scheme.ALPHA_NUMERIC) }, "Password should minimum 6 character and alpha numeric")
        }
    }
}