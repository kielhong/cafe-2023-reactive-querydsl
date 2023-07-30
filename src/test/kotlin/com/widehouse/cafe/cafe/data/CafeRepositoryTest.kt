package com.widehouse.cafe.cafe.data

import com.widehouse.cafe.config.QueryDslConfig
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(QueryDslConfig::class)
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

            val result = repository.findAllByCategoryId(category.id)
            result.size shouldBe 2
            result.forAll { it.category shouldBe category }

            result.forEach {
                println(it.createdAt)
                println(it.updatedAt)
            }
        }
    }
}
