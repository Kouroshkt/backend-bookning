package org.iths.bookning.repositories;

import org.iths.bookning.collection.NewsEmails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsEmailsRepository extends MongoRepository<NewsEmails, String> {

}
