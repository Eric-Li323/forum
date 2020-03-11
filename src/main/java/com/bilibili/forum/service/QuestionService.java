package com.bilibili.forum.service;

import com.bilibili.forum.dto.PaginationDTO;
import com.bilibili.forum.dto.QuestionDTO;
import com.bilibili.forum.mapper.QuestionMapper;
import com.bilibili.forum.mapper.UserMapper;
import com.bilibili.forum.model.Question;
import com.bilibili.forum.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        //page健壮性处理
        if(page<1){
            page=1;
        }
        if(page > paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }

        //分页
        //5*(i-1)   size*(page-1)
        Integer offset =size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questions) {
            User user =userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO); //快速将一个对象上的属性拷贝到另一个对象上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
