package com.kiyotakeshi.library.security

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LibraryAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        response?.status = HttpServletResponse.SC_OK

        // カスタマイズしなかった場合の遷移(リダイレクトされる)
//        $ curl -i -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=adenim@example.com' -d 'pass=minim ut' http://localhost:8080/login
//        HTTP/1.1 302
//        X-Content-Type-Options: nosniff
//        X-XSS-Protection: 1; mode=block
//        Cache-Control: no-cache, no-store, max-age=0, must-revalidate
//        Pragma: no-cache
//        Expires: 0
//        X-Frame-Options: DENY
//        Set-Cookie: JSESSIONID=34C450E15448473E2C9DD771DEA15E04; Path=/; HttpOnly
//        Location: http://localhost:8080/
//        Content-Length: 0
//        Date: Fri, 19 Nov 2021 15:53:29 GMT
    }

}
