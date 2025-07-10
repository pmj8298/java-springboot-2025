package com.pknu.backboard.service;

import org.springframework.stereotype.Service;

import com.pknu.backboard.repository.AboutRepository;
import com.pknu.backboard.entity.About;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AboutService {

    private final AboutRepository aboutRepository;

    // public AboutService(AboutRepository aboutRepository){
    //     this.aboutRepository = ;
    // }
    // @RequiredArgsConstructor 이거랑 둘 중 하나만 써야함

    public About getAbout(){
     About about = this.aboutRepository.findAll().get(0);

     return about;

    }
}
