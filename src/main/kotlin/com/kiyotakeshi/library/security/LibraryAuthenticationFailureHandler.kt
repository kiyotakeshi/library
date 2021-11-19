package com.kiyotakeshi.library.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LibraryAuthenticationFailureHandler : AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        response?.status = HttpServletResponse.SC_UNAUTHORIZED

        // カスタマイズしなかった場合の遷移(リダイレクトされる)
//        $ curl -i -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=adenim@example.com' -d 'pass=minim u' http://localhost:8080/login
//        HTTP/1.1 302
//        Set-Cookie: JSESSIONID=7B0249E9A8FEFC3506E3F87F510DAD35; Path=/; HttpOnly
//        X-Content-Type-Options: nosniff
//        X-XSS-Protection: 1; mode=block
//        Cache-Control: no-cache, no-store, max-age=0, must-revalidate
//        Pragma: no-cache
//        Expires: 0
//        X-Frame-Options: DENY
//        Location: http://localhost:8080/login?error
//        Content-Length: 0
//        Date: Fri, 19 Nov 2021 15:53:32 GMT

    }

}
