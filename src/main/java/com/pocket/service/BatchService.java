package com.pocket.service;

import java.util.List;

import com.pocket.dto.BatchDTO;

public interface BatchService {

	BatchDTO addBatch(BatchDTO batch);

	BatchDTO getBatchById(Long id);

	List<BatchDTO> getAllBatches();

	BatchDTO updateBatch(Long id, BatchDTO batch);

	void deleteBatch(Long id);

}
