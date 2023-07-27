package com.widehouse.cafe.cafe.data

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CategoryQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CategoryQueryRepository {
    override fun findByName(name: String): Category? {
        return jpaQueryFactory.selectFrom(QCategory.category)
            .where(QCategory.category.name.eq(name))
            .fetchOne()
    }
}
