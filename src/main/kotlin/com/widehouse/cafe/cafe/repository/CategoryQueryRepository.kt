package com.widehouse.cafe.cafe.repository

import com.widehouse.cafe.cafe.model.Category

interface CategoryQueryRepository {
    fun findByName(name: String): Category?
}
