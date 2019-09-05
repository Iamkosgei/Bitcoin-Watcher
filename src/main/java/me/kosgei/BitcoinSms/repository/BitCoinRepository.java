package me.kosgei.BitcoinSms.repository;

import me.kosgei.BitcoinSms.model.Bitcoin;
import me.kosgei.BitcoinSms.model.Data;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BitCoinRepository extends CrudRepository<Data, Integer> {

//    @Modifying
//    @Transactional
//    @Query("delete from data")
//    void deleteAllWithQuery();
}
