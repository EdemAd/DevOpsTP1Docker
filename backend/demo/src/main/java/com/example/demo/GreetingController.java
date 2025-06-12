package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/departments")  // Point de base pour toutes les routes relatives aux départements
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Route pour obtenir la liste des étudiants d'un département donné
    @GetMapping("/{department}/students")
    public List<Student> getStudents(@PathVariable String department) {
        // Exemple simple : on renvoie une liste d'étudiants fictifs pour un département
        return List.of(
            new Student(1, "Eli", "Copter", department),
            new Student(2, "Emma", "Carena", department),
            new Student(3, "Jack", "Uzzi", department)
        );
    }

    // Route de base (comme dans l'exemple précédent)
    @GetMapping("/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // Classe interne pour représenter un étudiant
    static class Student {
        private long id;
        private String firstname;
        private String lastname;
        private String department;

        public Student(long id, String firstname, String lastname, String department) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.department = department;
        }

        public long getId() {
            return id;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getDepartment() {
            return department;
        }
    }

    // Classe interne pour le format de la réponse "greeting"
    record Greeting(long id, String content) {}
}
