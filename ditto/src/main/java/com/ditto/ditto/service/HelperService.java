package com.ditto.ditto.service;

import com.ditto.ditto.dto.HelperDto;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HelperService {
    private final HelperRepository helperRepository;

}
