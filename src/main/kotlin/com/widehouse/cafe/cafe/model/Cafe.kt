package com.widehouse.cafe.cafe.model

import com.widehouse.cafe.common.data.TimestampEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Cafe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val url: String,
    val name: String,
    val description: String,
    @ManyToOne
    val category: Category
) : TimestampEntity()
