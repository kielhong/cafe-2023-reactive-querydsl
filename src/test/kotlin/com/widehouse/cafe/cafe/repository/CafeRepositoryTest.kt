package com.widehouse.cafe.cafe.repository

import com.widehouse.cafe.cafe.model.Cafe
import com.widehouse.cafe.cafe.model.Category
import com.widehouse.cafe.cafe.model.QCafe
import com.widehouse.cafe.common.annotation.QueryDslTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@QueryDslTest
class CafeRepositoryTest(
    private val entityManager: TestEntityManager,
    private val repository: CafeRepository
) : StringSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        lateinit var category: Category

        beforeEach {
            category = entityManager.persist(Category(0, "category"))
        }

        "findAllByCategoryId" {
            (1..2).forEach {
                entityManager.persist(Cafe(0, "url$it", "name$it", "desc$it", category))
            }

            val predicate = QCafe.cafe.category.id.eq(category.id)
            val result = repository.findAll(predicate)

            // then
            result shouldHaveSize 2
            result.toList().forAll { it.category shouldBe category }
        }
    }
}
