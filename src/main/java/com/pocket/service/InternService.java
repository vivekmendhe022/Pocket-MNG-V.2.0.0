package com.pocket.service;

import java.util.List;

import com.pocket.dto.InternDTO;

public interface InternService {

	InternDTO addIntern(InternDTO intern);

    InternDTO getInternById(Long id);

    List<InternDTO> getAllInterns();

    InternDTO updateIntern(Long id, InternDTO intern);

    void deleteIntern(Long id);
}
