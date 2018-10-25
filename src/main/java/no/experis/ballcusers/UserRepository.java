package no.experis.ballcusers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import no.experis.ballcusers.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT t FROM User t WHERE username= :searchName")
    public Iterable<User> findByUsername(@Param("searchName") String searchName);

}