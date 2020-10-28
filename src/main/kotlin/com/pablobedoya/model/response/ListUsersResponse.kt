package com.pablobedoya.model.response

import com.beust.klaxon.Json

data class ListUsersResponse(

        var page: Int,

        @Json(name = "per_page")
        var perPage: Int,

        var total: Int,

        @Json(name = "total_pages")
        var totalPages: Int,

        var data: List<UserResponse>

)

data class UserResponse(

        var id: Int,

        var email: String,

        @Json(name = "first_name")
        var firstName: String,

        @Json(name = "last_name")
        var lastName: String,

        var avatar: String

)