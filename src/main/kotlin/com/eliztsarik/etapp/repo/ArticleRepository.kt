package com.eliztsarik.etapp.repo

import com.eliztsarik.etapp.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long> {
    fun findBySlug(slug: String): Article?

    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}