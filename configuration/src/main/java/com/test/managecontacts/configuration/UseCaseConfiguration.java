package com.test.managecontacts.configuration;

import com.test.managecontacts.usecases.contact.*;
import com.test.managecontacts.db.ContactAdapterImpl;
import com.test.managecontacts.usescases.security.LoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public GetAllContactsUseCase getAllContactsUseCase(ContactAdapter contactAdapter) {
        return new GetAllContactsUseCase(contactAdapter);
    }

    @Bean
    public InsertContactUseCase insertContactUseCase(ContactAdapter contactAdapter) {
        return new InsertContactUseCase(contactAdapter);
    }

    @Bean
    public SearchContactsUseCase searchContactsUseCase(ContactAdapter contactAdapter) {
        return new SearchContactsUseCase(contactAdapter);
    }

    @Bean
    public GetContactUseCase getContactUseCase(ContactAdapter contactAdapter) {
        return new GetContactUseCase(contactAdapter);
    }

    @Bean
    public UpdateContactUseCase updateContactUseCase(ContactAdapter contactAdapter) {
        return new UpdateContactUseCase(contactAdapter);
    }

    @Bean
    public MultiSearchUseCase multiSearchUseCase(ContactAdapter contactAdapter) {
        return new MultiSearchUseCase(contactAdapter);
    }

    @Bean
    public LoginUseCase loginUseCase(ContactAdapter contactAdapter) {
        return new LoginUseCase(contactAdapter);
    }

    @Bean
    public ContactAdapter contactAdapter() {
        return new ContactAdapterImpl();
    }
}
