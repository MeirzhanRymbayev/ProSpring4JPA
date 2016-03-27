package com.apress.prospring4.ch8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/*К классу применено несколько аннотаций. Аннотация @Service предназначена
для идентификации класса как компонента Spring, который предоставляет бизнес-
службы другому уровню; этот бин Spring получает имя jpaContactService.
Аннотация @Repository указывает, что класс содержит логику доступа к данным
и заставляет Spring транслировать исключения, специфичные для поставщика, в
иерархию DataAccessException, определенную Spring. Как вам уже должно быть
известно, аннотация @Transactional используется для определения требований к
транзакции.*/
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    private Log log = LogFactory.getLog(ContactServiceImpl.class);

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }

    public List<Contact> findAllWithDetail() {
        return null;
    }

    public Contact findById() {
        return null;
    }

    public Contact save(Contact contact) {
        return null;
    }

    public void delete(Contact contact) {


    }
}

