package com.vcx.api.service;

import com.vcx.api.entity.Note;
import com.vcx.api.repository.NoteRepository;
import lombok.Data;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class NoteService {

    public final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Page<Note> notes(Pageable PageRequest) {
        return noteRepository.searchAll(PageRequest);
    }

    public Page<Note> notesByCopmany(Long id, Pageable PageRequest) {
        return noteRepository.searchAllbyCompany(id, PageRequest);
    }

    public Note save(Note note){
        if(note.getTaker() != note.getProvider()){
            check_companies(note);
            return noteRepository.save(note);
        }else{
            throw new RuntimeException("Taker and Provider are equal");
        }
    }

    public String deleteById(Long id){
        try{
            noteRepository.deleteById(id);
            return "Deletado com Sucesso";
        }catch (Exception e){
            return "Problema em deletar "+e.getMessage();
        }
    }

    public void check_companies(Note note){
        if(note.getTaker().getTypeEnum().name() != "TAKER"){
            throw new RuntimeException("taker not is taker!");
        }

        if(note.getProvider().getTypeEnum().name() != "PROVIDER"){
            throw new RuntimeException("provider not is provider!");
        }
    }
}
