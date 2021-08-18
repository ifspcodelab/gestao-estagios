package br.edu.ifsp.ifspcodelab.gestaoestagiosbackend.course;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courses")
@CrossOrigin
@AllArgsConstructor
public class CourseRestController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping
    public ResponseEntity<CourseDto> create(@Valid @RequestBody CourseCreateDto courseCreateDto) {
        Course course = courseService.create(courseCreateDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseId}")
            .buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(courseMapper.to(course));
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> index() {
        List<CourseDto> courses = courseService.findAll().stream()
            .map(courseMapper::to)
            .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto> show(@PathVariable UUID courseId) {
        return ResponseEntity.ok(courseMapper.to(courseService.findById(courseId)));
    }

    @PutMapping("{courseId}")
    public ResponseEntity<CourseDto> update(@PathVariable UUID courseId, @Valid @RequestBody CourseCreateDto courseCreateDto) {
        return ResponseEntity.ok(courseMapper.to(courseService.update(courseId, courseCreateDto)));
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> delete(@PathVariable UUID courseId) {
        courseService.delete(courseId);
        return ResponseEntity.noContent().build();
    }
}
