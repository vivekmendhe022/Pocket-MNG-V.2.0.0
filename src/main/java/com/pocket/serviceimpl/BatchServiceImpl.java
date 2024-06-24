package com.pocket.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocket.dto.BatchDTO;
import com.pocket.entity.Batch;
import com.pocket.repository.BatchRepository;
import com.pocket.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public BatchDTO addBatch(BatchDTO dto) {
        Batch batchEntity = convertToEntity(dto);
        Batch savedBatch = batchRepository.save(batchEntity);
        return convertToDTO(savedBatch);
    }

    @Override
    public BatchDTO getBatchById(Long id) {
        Batch batch = batchRepository.findById(id).orElseThrow(() -> new RuntimeException("Batch not found"));
        return convertToDTO(batch);
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        return batches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BatchDTO updateBatch(Long id, BatchDTO dto) {
        Batch existingBatch = batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        updateEntity(existingBatch, dto);
        Batch updatedBatch = batchRepository.save(existingBatch);
        return convertToDTO(updatedBatch);
    }

    @Override
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }

    private Batch convertToEntity(BatchDTO dto) {
        Batch batch = new Batch();
        batch.setTitle(dto.getTitle());
        batch.setCreatedOn(dto.getCreatedOn());
        batch.setDuration(dto.getDuration());
        batch.setDescription(dto.getDescription());
        return batch;
    }

    private BatchDTO convertToDTO(Batch batch) {
        BatchDTO dto = new BatchDTO();
        dto.setBatchID(batch.getBatchID());
        dto.setTitle(batch.getTitle());
        dto.setCreatedOn(batch.getCreatedOn());
        dto.setDuration(batch.getDuration());
        dto.setDescription(batch.getDescription());
        return dto;
    }

    private void updateEntity(Batch existingBatch, BatchDTO dto) {
        existingBatch.setTitle(dto.getTitle());
        existingBatch.setCreatedOn(dto.getCreatedOn());
        existingBatch.setDuration(dto.getDuration());
        existingBatch.setDescription(dto.getDescription());
    }
}
