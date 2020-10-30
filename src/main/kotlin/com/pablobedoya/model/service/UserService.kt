package com.pablobedoya.model.service

import com.beust.klaxon.Klaxon
import com.pablobedoya.model.response.CreateUserResponse
import com.pablobedoya.model.response.ListUsersResponse
import com.pablobedoya.model.response.ResponseData
import java.io.StringReader

class UserService {

    companion object {
        const val BASE_URI = "https://reqres.in"
        const val USERS_PATH = "/api/users"
    }

    fun createUser(json: Map<String, String>): ResponseData<CreateUserResponse> {
        val response = khttp.post(url = BASE_URI + USERS_PATH, json = json)
        val createUserResponse: ResponseData<CreateUserResponse> = ResponseData()
        createUserResponse.content = Klaxon().parse<CreateUserResponse>(StringReader(response.jsonObject.toString()))
        createUserResponse.statusCode = response.statusCode
        return createUserResponse
    }

    fun getUsers(params: Map<String, String>): ResponseData<ListUsersResponse> {
        val response = khttp.get(url = BASE_URI + USERS_PATH, params = params)
        val listUsersResponse: ResponseData<ListUsersResponse> = ResponseData()
        listUsersResponse.content = Klaxon().parse<ListUsersResponse>(StringReader(response.jsonObject.toString()))
        listUsersResponse.statusCode = response.statusCode
        return listUsersResponse
    }

}