package com.eliztsarik.etapp.configuration

import com.eliztsarik.etapp.entity.Article
import com.eliztsarik.etapp.entity.User
import com.eliztsarik.etapp.repo.ArticleRepository
import com.eliztsarik.etapp.repo.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) =
            ApplicationRunner {
                val nemo = userRepository.save(User("nemofish", "Nemo", "UnknownFish"))
                articleRepository.save(Article(
                        title = "First book",
                        headline = "Headline",
                        content = "Content",
                        author = nemo
                ))
                articleRepository.save(Article(
                        title = "Second book",
                        headline = "Headline",
                        content = "Content",
                        author = nemo
                ))
            }
}