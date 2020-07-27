package com.vcx.api.service;

import com.vcx.api.entity.Company;
import com.vcx.api.repository.CompanyRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class CompanyService {

    public final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Page<Company> companies(Pageable PageRequest) {
        return companyRepository.searchAll(PageRequest);
    }

    public String deleteById(Long id){
        try{
            companyRepository.deleteById(id);
            return "Deletado com Sucesso";
        }catch (Exception e){
            return "Problema em deletar "+e.getMessage();
        }
    }


}
