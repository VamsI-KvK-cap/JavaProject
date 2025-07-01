package com.example.claims;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ClaimsRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    private static final Logger logger = LoggerFactory.getLogger(ClaimsRepository.class);

    @Transactional
    public void saveClaim(Claim claim) {
        validateClaim(claim);
        try {
            entityManager.persist(claim);
        } catch (Exception e) {
            logger.error("Error saving claim", e);
            throw new ClaimsException("Error saving claim", e);
        }
    }

    public List<Claim> findClaimsByStatus(ClaimStatus status) {
        try {
            return entityManager.createQuery("SELECT c FROM Claim c WHERE c.status = :status", Claim.class)
                    .setParameter("status", status)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving claims by status", e);
            throw new ClaimsException("Error retrieving claims by status", e);
        }
    }

    private void validateClaim(Claim claim) {
        if (claim == null || claim.getId() == null || claim.getStatus() == null) {
            throw new IllegalArgumentException("Claim or its required fields cannot be null");
        }
    }
}