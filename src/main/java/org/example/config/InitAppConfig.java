package org.example.config;

import org.example.ContactService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application-init.properties")
@Profile("init")
public class InitAppConfig {
    @Value("${contacts.file.init}")
    private String filePath;

    @Bean
    public boolean loadInitialContacts(ContactService contactService) {
        contactService.loadContactsFromFile(filePath);
        return true;
    }
}
