package com.example.springbootpractice.repository;

import com.example.springbootpractice.model.entity.UserPoint;
import com.example.springbootpractice.model.enums.CurrencyType;
import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointRepository extends JpaRepository<UserPoint, Long> {

  List<UserPoint> findByUserSeq(long userSeq);

  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  Optional<UserPoint> findByUserSeqAndCurrency(long userSeq, CurrencyType currency);

}
