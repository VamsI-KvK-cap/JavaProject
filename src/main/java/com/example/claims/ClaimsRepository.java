package com.example.claims;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClaimsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveClaim(Claim claim) {
        try {
            entityManager.persist(claim);
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            throw new RuntimeException("Error saving claim", e);
        }
    }

    public List<Claim> findClaimsByStatus(ClaimStatus status) {
        try {
            return entityManager.createQuery("SELECT c FROM Claim c WHERE c.status = :status", Claim.class)
                    .setParameter("status", status)
                    .getResultList();
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            throw new RuntimeException("Error retrieving claims by status", e);
        }
    }
}