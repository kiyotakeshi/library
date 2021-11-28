package com.kiyotakeshi.library.domain.entity

import com.kiyotakeshi.library.domain.RoleType
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
@ApiModel(description = "ユーザ情報")
data class User(

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

    override fun toString(): String {
        return "User(email='$email', password='$password', name='$name', roleType=$roleType, id=$id)"
    }
}
