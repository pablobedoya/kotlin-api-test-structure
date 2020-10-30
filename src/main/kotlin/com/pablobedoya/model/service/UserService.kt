package com.pablobedoya.model.service

import com.beust.klaxon.Klaxon
import com.pablobedoya.model.response.ListUsersResponse
import com.pablobedoya.model.response.ResponseData
import java.io.StringReader

class UserService {

    companion object {
        const val BASE_URI = "https://reqres.in"
        const val USERS_PATH = "/api/users"
    }

    fun getUsers(params: Map<String, String>): ResponseData<ListUsersResponse> {
        val response = khttp.get(url = BASE_URI + USERS_PATH, params = params)
        val listUsersResponse: ResponseData<ListUsersResponse> = ResponseData()
        listUsersResponse.content = Klaxon().parse<ListUsersResponse>(StringReader(response.jsonObject.toString()))
        listUsersResponse.statusCode = response.statusCode
        return listUsersResponse
    }

}