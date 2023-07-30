package com.widehouse.cafe.cafe.data

interface CafeQueryRepository {
    fun findAllByCategoryId(categoryId: Long): List<Cafe>
}
