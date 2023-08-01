package com.widehouse.cafe.article.model

import com.widehouse.cafe.common.data.TimestampEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val cafeId: Long,
    var subject: String,
    var content: String
) : TimestampEntity()
