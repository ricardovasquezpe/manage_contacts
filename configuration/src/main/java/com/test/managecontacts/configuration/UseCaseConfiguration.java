package com.test.managecontacts.configuration;

import com.test.managecontacts.usecases.contact.ContactAdapter;
import com.test.managecontacts.usecases.contact.GetAllContactsUseCase;
import com.test.managecontacts.db.ContactAdapterImpl;
import com.test.managecontacts.usecases.contact.InsertContactUseCase;
import com.test.managecontacts.usecases.contact.SearchContactsUseCase;
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
    public ContactAdapter contactAdapter() {
        return new ContactAdapterImpl();
    }
}
