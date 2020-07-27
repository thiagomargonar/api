package com.vcx.api.api;

import com.vcx.api.entity.Company;
import com.vcx.api.service.CompanyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("company")
public class CompanyAPI implements Serializable {

    private final CompanyService companyService;

    public CompanyAPI(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<?> ListAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
        return new ResponseEntity<>(companyService.companies(PageRequest.of(page, pageSize)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.getCompanyRepository().save(company), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.getCompanyRepository().save(company), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyService.deleteById(id), HttpStatus.OK);
    }
}
