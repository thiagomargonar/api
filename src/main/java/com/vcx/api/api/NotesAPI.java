package com.vcx.api.api;

import com.vcx.api.entity.Note;
import com.vcx.api.service.NoteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("note")
public class NotesAPI implements Serializable {

    private final NoteService noteService;

    public NotesAPI(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping()
    public ResponseEntity<?> ListAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
        return new ResponseEntity<>(noteService.notes(PageRequest.of(page, pageSize)), HttpStatus.OK);
    }

    @GetMapping(path = "/provider")
    public ResponseEntity<?> noteByCompany(Long provider ,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
        return new ResponseEntity<>(noteService.notesByCopmany(provider, PageRequest.of(page, pageSize)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.save(note),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.save(note), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(noteService.deleteById(id), HttpStatus.OK);
    }
}
