package com.pablobedoya

import com.pablobedoya.model.response.CreateUserResponse
import com.pablobedoya.model.response.ListUsersResponse
import com.pablobedoya.model.response.ResponseData
import com.pablobedoya.model.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object UserSpec : Spek({
    val userService = UserService()

    Feature("Create user") {
        var requestName: String = ""
        var requestJob: String = ""
        var response: ResponseData<CreateUserResponse>? = null
        Scenario("Create user successfully") {
            Given("I want to register a user") {
                requestName = "Morpheus"
                requestJob = "Leader"
            }
            When("I submit a request to register it") {
                response = userService.createUser(mapOf("name" to requestName, "job" to requestJob))
            }
            Then("Should return that user was successfully created") {
                assertEquals(201, response?.statusCode)
                assertEquals(requestName, response?.content?.name)
                assertEquals(requestJob, response?.content?.job)
            }
        }
    }

    Feature("List users") {
        var requestPage: Int? = null
        var response: ResponseData<ListUsersResponse>? = null
        Scenario("Get users successfully") {
            Given("I want to search users first page") {
                requestPage = 1
            }
            When("I submit a request to get users first page") {
                response = userService.getUsers(mapOf("page" to requestPage.toString()))
            }
            Then("Should return users first page successfully") {
                assertEquals(200, response?.statusCode)
                assertEquals(requestPage, response?.content?.page)
            }
        }
    }
})