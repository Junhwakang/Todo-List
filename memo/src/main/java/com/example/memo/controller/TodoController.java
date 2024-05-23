package com.example.memo.controller;

import com.example.memo.controller.entity.Todo;
import com.example.memo.controller.entity.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos",todoRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }

    @PostMapping("/add")
    public String addTodoSubmit(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable("id") Long id, Model model) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id"+id));
        model.addAttribute("todo", todo);
        return "edit-todo";
    }
    @PostMapping("/edit/{id}")
    public String editTodoSubmit(@PathVariable("id")long id,@ModelAttribute Todo todo) {todoRepository.save(todo);
    return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id"+id));
        todoRepository.delete(todo);
        return "redirect:/";
    }






    }
}
