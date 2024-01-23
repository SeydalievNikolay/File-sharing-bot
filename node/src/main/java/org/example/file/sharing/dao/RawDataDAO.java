package org.example.file.sharing.dao;

import org.example.file.sharing.model.RawData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawDataDAO extends JpaRepository<RawData, Long> {


}
