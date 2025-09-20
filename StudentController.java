package org.example.demo; // Declares that this class is in the 'org.example.demo' package

// Import necessary Spring and Java classes
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController // Tells Spring that this class is a REST controller (handles HTTP requests and returns JSON)
@RequestMapping("/students") // All routes in this controller will start with '/students'
public class StudentController {

    // In-memory list to store Student objects (like a fake database)
    private List<Student> students = new ArrayList<>();

    // Simple counter to generate unique student IDs
    private int idCounter = 1;

    // CREATE: Handles HTTP POST requests to /students
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(idCounter++);   // Set a unique ID for the student and increment the counter
        students.add(student);       // Add the student to the list
        return student;              // Return the added student as the response (in JSON)
    }

    // READ ALL: Handles HTTP GET requests to /students
    @GetMapping
    public List<Student> getStudents() {
        return students; // Return the full list of students
    }

    // READ ONE: Handles HTTP GET requests to /students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        // Search for the student with the matching ID using Java Streams
        return students.stream()
                .filter(s -> s.getId() == id)  // Filter by ID
                .findFirst()                   // Return the first match
                .orElse(null);                 // Return null if no match found
    }

    // UPDATE: Handles HTTP PUT requests to /students/{id}
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                // Update the student's name and course
                s.setName(updatedStudent.getName());
                s.setCourse(updatedStudent.getCourse());
                return s; // Return the updated student
            }
        }
        return null; // Return null if no student with the given ID was found
    }

    // DELETE: Handles HTTP DELETE requests to /students/{id}
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        // Remove any student with the given ID from the list
        students.removeIf(s -> s.getId() == id);
        return "Student with ID " + id + " deleted."; // Return confirmation message
    }
}
