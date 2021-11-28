package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.entity.User
import com.kiyotakeshi.library.usecase.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/users"], produces = ["application/json"])
class UserController(
    private val userService: UserService
) {
    // TODO: ユーザのマイページに使う？ `/{email}` は変える
    // TODO: Spring Security で自身のものしか見れないように制御する
    @ApiOperation("ユーザ一情報の取得")
    @GetMapping("/{email}")
    fun getUser(@PathVariable email: String): User {
        return userService.getUserByEmail(email)
    }

    // TODO: プロフィール編集などできるようにするのであれば
    // @PutMapping
}
