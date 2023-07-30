package com.widehouse.cafe.cafe.data

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CafeQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CafeQueryRepository {
    override fun findAllByCategoryId(categoryId: Long): List<Cafe> {
        return jpaQueryFactory.selectFrom(QCafe.cafe)
            .where(QCafe.cafe.category.id.eq(categoryId))
            .fetch()
    }
}
