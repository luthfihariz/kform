# kform
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
Kotlin easy to use form validation extension, works for EditText and TextInputLayout

## Usage

Email validation

```kotlin
submitButton.setOnClickListener{
    email.validate({it.isValidEmail()}, errorMessage = "Not a valid email")
}
```

Character Limitation

```kotlin
submitButton.setOnClickListener{
   fullName.validate({it.minimum(3)}, errorMessage = "Minimum 3 characters")
   phoneNumber.validate({it.maximum(13)}, errorMessage = "Maximum 13 characters")
   pin.validate({it.between(3, 6)}, errorMessage = "Should more than 3 and less than 6 characters")
}
```

Validate while typing (afterTextChanged)

```kotlin
email.validateWhileTyping({it.isValidEmail}, errorMessage = "Not a valid email")
```

Validate when view focus is false

```kotlin
email.validateOffFocus({it.isValidEmail}, errorMessage = "Not a valid email")
```

## WIP
- Custom error view
- Scheme matching (alpha numeric, numeric, etc)

## License
```
Copyright 2016 Shintaro Katafuchi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

