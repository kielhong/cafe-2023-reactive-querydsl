package com.widehouse.cafe.cafe.data

interface CategoryQueryRepository {
    fun findByName(name: String): Category?
}
