package com.widehouse.cafe.cafe.repository

import com.widehouse.cafe.cafe.model.Category
import com.widehouse.cafe.common.annotation.QueryDslTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@QueryDslTest
class CategoryRepositoryTest(
    private val entityManager: TestEntityManager,
    private val repository: CategoryRepository
) : StringSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        "findAllByName" {
            val category = entityManager.persist(Category(0, "category"))

            val result = repository.findByName("category")
            result shouldBe category
        }
    }
}
