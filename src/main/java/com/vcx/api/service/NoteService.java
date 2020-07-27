package com.vcx.api.service;

import com.vcx.api.repository.NoteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NoteService {

    public final NoteRepository companyRepository;

    public NoteService(NoteRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
