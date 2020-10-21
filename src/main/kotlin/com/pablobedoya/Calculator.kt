package com.pablobedoya

class Calculator {

    fun addition(a: Int, b: Int) = a + b

    fun subtraction(a: Int, b: Int) = a - b

    fun multiplication(a: Int, b: Int) = a * b

    fun division(a: Int, b: Int) = if (b == 0) {
        throw DivideByZeroException(a)
    } else {
        a / b
    }

}