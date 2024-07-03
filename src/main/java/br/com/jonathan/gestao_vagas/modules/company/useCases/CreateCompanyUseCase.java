package br.com.jonathan.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jonathan.gestao_vagas.exceptions.UserFoundException;
import br.com.jonathan.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.jonathan.gestao_vagas.modules.company.repositories.CompanyRepository;

public class CreateCompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
            .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });

        return this.companyRepository.save(companyEntity);
    }
}
