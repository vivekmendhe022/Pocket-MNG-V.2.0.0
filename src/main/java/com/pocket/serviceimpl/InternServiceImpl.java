package com.pocket.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pocket.dto.InternDTO;
import com.pocket.entity.Intern;
import com.pocket.entity.Batch;
import com.pocket.repository.InternRepository;
import com.pocket.repository.BatchRepository;
import com.pocket.service.InternService;

@Service
public class InternServiceImpl implements InternService {

	@Autowired
	private InternRepository internRepository;

	@Autowired
	private BatchRepository batchRepository;

	@Override
	public InternDTO addIntern(InternDTO dto) {
		Intern internEntity = convertToEntity(dto);

		if (dto.getBatchID() != null) {
			Batch batch = batchRepository.findById(dto.getBatchID())
					.orElseThrow(() -> new RuntimeException("Batch not found with id: " + dto.getBatchID()));

			internEntity.setBatch(batch);
		} else {
			internEntity.setBatch(null);
		}

		try {
			Intern savedIntern = internRepository.save(internEntity);
			return convertToDTO(savedIntern); 
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Contact must be unique and 10 digits long", e);
		}
	}

	@Override
	public InternDTO getInternById(Long id) {
		Intern intern = internRepository.findById(id).orElseThrow(() -> new RuntimeException("Intern not found"));
		return convertToDTO(intern);
	}

	@Override
	public List<InternDTO> getAllInterns() {
		List<Intern> interns = internRepository.findAll();
		return interns.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public InternDTO updateIntern(Long id, InternDTO dto) {
		Intern existingIntern = internRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Intern not found"));
		
		Batch batch = batchRepository.findById(dto.getBatchID())
				.orElseThrow(() -> new RuntimeException("Batch not found"));
		updateEntity(existingIntern, dto);
		existingIntern.setBatch(batch);
		
		try {
			Intern updatedIntern = internRepository.save(existingIntern);
			return convertToDTO(updatedIntern);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Contact must be unique and 10 digits long", e);
		}
	}

	@Override
	public void deleteIntern(Long id) {
		internRepository.deleteById(id);
	}

	private Intern convertToEntity(InternDTO dto) {
		Intern intern = new Intern();
		intern.setName(dto.getName());
		intern.setCollege(dto.getCollege());
		intern.setEmail(dto.getEmail());
		intern.setCity(dto.getCity());
		intern.setContact(dto.getContact());
		intern.setType(dto.getType());
		intern.setRemark(dto.getRemark());
		return intern;
	}

	private InternDTO convertToDTO(Intern intern) {
		InternDTO dto = new InternDTO();
		dto.setId(intern.getId());
		dto.setName(intern.getName());
		dto.setCollege(intern.getCollege());
		dto.setEmail(intern.getEmail());
		dto.setCity(intern.getCity());
		dto.setContact(intern.getContact());
		
		if (intern.getBatch() != null) {
			dto.setBatchID(intern.getBatch().getBatchID());
		} else {
			dto.setBatchID(null);
		}

		dto.setType(intern.getType());
		dto.setRemark(intern.getRemark());

		return dto;
	}

	private void updateEntity(Intern existingIntern, InternDTO dto) {
		existingIntern.setName(dto.getName());
		existingIntern.setCollege(dto.getCollege());
		existingIntern.setEmail(dto.getEmail());
		existingIntern.setCity(dto.getCity());
		existingIntern.setContact(dto.getContact());
		existingIntern.setType(dto.getType());
		existingIntern.setRemark(dto.getRemark());
	}
}
