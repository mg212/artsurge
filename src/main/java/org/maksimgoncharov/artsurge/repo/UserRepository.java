package org.maksimgoncharov.artsurge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.maksimgoncharov.artsurge.model.User;






@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
