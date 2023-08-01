package com.widehouse.cafe.article.repository

import com.widehouse.cafe.article.model.Article
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long>, QuerydslPredicateExecutor<Article>
