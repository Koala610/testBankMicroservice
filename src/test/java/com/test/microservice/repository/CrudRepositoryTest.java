package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import jakarta.persistence.MappedSuperclass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MappedSuperclass
public abstract class CrudRepositoryTest {
    public abstract AbstractEntity createTestEntity();
    protected CrudRepository mainRepository;
    protected CrudRepository additionalRepository;

    public CrudRepositoryTest(CrudRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public CrudRepositoryTest(CrudRepository mainRepository, CrudRepository additionalRepository) {
        this(mainRepository);
        this.additionalRepository = additionalRepository;
    }
    public abstract void deleteTestEntity(AbstractEntity entity);

    public abstract AbstractEntity updateTestEntity(AbstractEntity entity);

    @Test
    public void testCreate() {
        long prev_size = mainRepository.count();
        AbstractEntity entity = createTestEntity();
        Iterable<AbstractEntity> entities = mainRepository.findAll();
        assertThat(entities).hasSize((int) (prev_size+1));
        deleteTestEntity(entity);

    }
    @Test
    public void testUpdate() {
        AbstractEntity entity = createTestEntity();
        AbstractEntity updatedEntity = updateTestEntity(entity);
        Optional<AbstractEntity>checkEntity = mainRepository.findById(updatedEntity.getId());
        assertThat(checkEntity).isNotNull();
        deleteTestEntity(entity);
    }
    @Test
    public void testDeletion() {
        long prev_size = mainRepository.count();
        AbstractEntity entity = createTestEntity();
        deleteTestEntity(entity);
        Iterable<AbstractEntity> entities = mainRepository.findAll();
        assertThat(entities).hasSize((int) prev_size);

    }
}
