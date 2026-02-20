package com.youngsophomore.kmppractice

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform