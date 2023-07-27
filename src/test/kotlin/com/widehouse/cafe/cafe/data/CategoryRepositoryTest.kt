package com.widehouse.cafe.cafe.data

import com.widehouse.cafe.config.QueryDslConfig
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import java.time.LocalDateTime

@DataJpaTest
@Import(QueryDslConfig::class)
class CategoryRepositoryTest(
    private val entityManager: TestEntityManager,
    private val repository: CategoryRepository
) : StringSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        "findAllByName" {
            val category = entityManager.persist(Category(0, "category", LocalDateTime.now()))

            val result = repository.findByName("category")
            result shouldBe category
        }
    }
}
