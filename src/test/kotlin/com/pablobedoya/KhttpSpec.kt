package com.pablobedoya

import khttp.responses.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object KhttpSpec : Spek({
    val baseUri = "https://reqres.in"

    Feature("Create user") {
        val path = "/api/users"
        var requestName: String? = null
        var requestJob: String? = null
        var response: Response? = null
        Scenario("Create user successfully") {
            Given("I want to register a user") {
                requestName = "Morpheus"
                requestJob = "Leader"
            }
            When("I submit a request to register it") {
                response = khttp.post(url = baseUri + path, json = mapOf("name" to requestName, "job" to requestJob))
            }
            Then("Should return that user was successfully created") {
                val statusCode = response?.statusCode
                val responseName = response?.jsonObject?.get("name")
                val responseJob = response?.jsonObject?.get("job")
                assertEquals(201, statusCode)
                assertEquals(requestName, responseName)
                assertEquals(requestJob, responseJob)
            }
        }
    }

    Feature("List users") {
        val path = "/api/users"
        var requestPage: Int? = null
        var response: Response? = null
        Scenario("Get users successfully") {
            Given("I want to search users first page") {
                requestPage = 1
            }
            When("I submit a request to get users first page") {
                response = khttp.get(url = baseUri + path, params = mapOf("page" to requestPage.toString()))
            }
            Then("Should return users first page successfully") {
                val statusCode = response?.statusCode
                val responsePage = response?.jsonObject?.get("page")
                assertEquals(200, statusCode)
                assertEquals(requestPage, responsePage)
            }
        }
    }
})