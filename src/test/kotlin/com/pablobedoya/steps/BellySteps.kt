package com.pablobedoya.steps

import io.cucumber.java.PendingException
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class BellySteps {
    @Given("I have {int} cukes in my belly")
    fun i_have_cukes_in_my_belly(cukes: Int) {
        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }

    @When("I wait {int} hour")
    fun i_wait_hour(hour: Int) {
        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }

    @Then("my belly should growl")
    fun my_belly_should_growl() {
        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }
}