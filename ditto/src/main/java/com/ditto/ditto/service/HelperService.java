package com.ditto.ditto.service;

import com.ditto.ditto.dto.CommentDto;
import com.ditto.ditto.dto.HelpSeekerDto;
import com.ditto.ditto.dto.HelperDto;
import com.ditto.ditto.entity.CommentEntity;
import com.ditto.ditto.entity.HelpSeekerEntity;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HelperService {
    private final HelperRepository helperRepository;

    //helper 생성
    public void create(HelperDto helperDto) {
        HelperEntity helperEntity = new HelperEntity();
        helperEntity.setNickname(helperDto.getNickname());
        helperEntity.setPhoneNumber(helperDto.getPhoneNumber());
        helperRepository.save(helperEntity);
    }

    // 포인트, 봉사시간, 도움 횟수 조회
    public HelperDto readPoint(Long helperId) {
        HelperEntity helperEntity = helperRepository.findById(helperId).get();

        HelperDto helperDto = new HelperDto();
        helperDto.setNickname(helperEntity.getNickname());
        helperDto.setPoint(helperEntity.getPoint());
        helperDto.setTime(helperEntity.getTime());
        helperDto.setHelpCount(helperEntity.getHelpCount());
        return helperDto;
    }

    public List<CommentDto> findComment(Long helperId) {
        HelperEntity helperEntity = helperRepository.findById(helperId).get();
        List<CommentEntity> commentEntity = helperEntity.getCommentEntity();
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (CommentEntity entity : commentEntity) {
            commentDtoList.add(new CommentDto(
                    entity.getId(),
                    entity.getComment()
            ));
        }
        return commentDtoList;
    }

    // helper 조회
    public HelperDto read(Long helperId) {
        HelperEntity helperEntity = helperRepository.findById(helperId).get();

        return new HelperDto(
                helperEntity.getId(),
                helperEntity.getNickname(),
                helperEntity.getPhoneNumber(),
                helperEntity.getTime(),
                helperEntity.isHelpOnOff(),
                helperEntity.getPoint(),
                helperEntity.getGrade(),
                helperEntity.getHelpCount(),
                helperEntity.getCategoryEntity());
    }
}
