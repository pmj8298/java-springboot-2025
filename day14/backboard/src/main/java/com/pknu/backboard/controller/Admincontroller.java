package com.pknu.backboard.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.service.AboutService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class Admincontroller {

    private final AboutService aboutService;

    @GetMapping("/manage")
    public String managePage(About about) {
        About opAbout = aboutService.getAbout();
        about.setTitle(opAbout.getTitle());
        about.setSubtitle(opAbout.getSubtitle());
        about.setOurMission(opAbout.getOurMission());
        about.setOurVision(opAbout.getOurVision());
        about.setSchoolImgPath(opAbout.getSchoolImgPath());

        return "admin/manage";
    }

    @PostMapping("/about")
    public String postAbout(About about, Principal principal) {

        About originAbout = aboutService.getAbout();

        originAbout.setTitle(about.getTitle());
        originAbout.setSubtitle(about.getSubtitle());
        originAbout.setOurMission(about.getOurMission());
        originAbout.setOurVision(about.getOurVision());
        originAbout.setSchoolImgPath(about.getSchoolImgPath());

        aboutService.putAbout(originAbout);

        
        return "redirect:/admin/manage";
    }
    
    
}
