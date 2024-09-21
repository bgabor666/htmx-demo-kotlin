package com.example.htmxdemokotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime

@Controller
class HomeController {

    companion object {
        val searchResults = listOf("one", "two", "three", "four", "five")
    }

    @GetMapping("/")
    fun home() : String {
        return "index"
    }

    @GetMapping("/search")
    fun search(q: String, model: Model) : String {
        val filtered = searchResults.filter {
            it.startsWith(q.lowercase())
        }

        model.addAttribute("results", filtered)
        return "search :: results"
    }

    @PostMapping("/clicked")
    fun clicked(model: Model) : String {
        model.addAttribute("now", LocalDateTime.now().toString())
        return "clicked :: result"
    }
}
