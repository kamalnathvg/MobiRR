package org.kamalnathvg.mobirr

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform