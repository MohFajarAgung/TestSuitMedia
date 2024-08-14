package android.suitmedia.model.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val data: List<User>
)
data class User(
    @SerializedName("id")
    val id : Int?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("avatar")
    val avatar: String?
)