package com.kiyotakeshi.library.domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
@ApiModel(description = "ユーザ情報")
class User(

    @ApiModelProperty(value = "ログイン時にパスワードと共に使用される", example = "test@example.com", required = true)
    @field:Email
    val email: String,

    @field:Size(min = 6, message = "Password is too short")
    @ApiModelProperty(
        value = "ユーザのリクエストをハッシュ化したもの",
        example = "$2a$10dxKi.R0LKtFufMdeEmn/YuFRSQn3gSk702mTevwLUm2wfseL6GBha",
        required = true
    )
    val password: String,

    @ApiModelProperty(value = "ユーザ名", example = "mike", required = true)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    val roleType: RoleType
) {
    // id は DB で自動採番するためコンストラクタに含めない
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (name != other.name) return false
        if (roleType != other.roleType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + roleType.hashCode()
        return result
    }

    override fun toString(): String {
        return "User(id=$id, email='$email', password='$password', name='$name', roleType=$roleType)"
    }
}
