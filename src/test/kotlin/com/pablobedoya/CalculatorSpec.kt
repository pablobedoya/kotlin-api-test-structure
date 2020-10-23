package com.pablobedoya

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object CalculatorSpec : Spek({

    Feature("calculator feature") {
        val calculator = Calculator()
        Scenario("do addition") {
            var a = 0
            var b = 0
            var sum = 0
            val result = 21
            Given("setting a and b values") {
                a = 4
                b = 17
            }
            When("addition a with b") {
                sum = calculator.addition(a, b)
            }
            Then("it should return addition between a and b values") {
                assertEquals(result, sum)
            }
        }
    }

})