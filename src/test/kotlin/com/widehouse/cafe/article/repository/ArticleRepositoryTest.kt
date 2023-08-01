package com.widehouse.cafe.article.repository

import com.widehouse.cafe.article.model.Article
import com.widehouse.cafe.article.model.QArticle.article
import com.widehouse.cafe.cafe.model.Cafe
import com.widehouse.cafe.cafe.model.Category
import com.widehouse.cafe.common.annotation.QueryDslTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@QueryDslTest
class ArticleRepositoryTest(
    private val entityManager: TestEntityManager,
    private val repository: ArticleRepository
) : StringSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        lateinit var cafe: Cafe

        beforeEach {
            val category = entityManager.persist(Category(0, "category"))
            cafe = entityManager.persist(Cafe(0, "cafe", "name", "desc", category))

            (1..2).forEach {
                entityManager.persist(Article(0, cafe.id, "subject$it", "content$it"))
            }
        }

        "findAllByCafe" {
            val result = repository.findAll(article.cafeId.eq(cafe.id))

            result shouldHaveSize 2
            result.toList().forAll { it.cafeId shouldBe cafe.id }
        }
    }
}
