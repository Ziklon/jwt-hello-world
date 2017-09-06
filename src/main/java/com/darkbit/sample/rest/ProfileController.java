package com.darkbit.sample.rest;

import com.darkbit.sample.domain.Profile;
import com.darkbit.sample.repository.ProfileRepository;
import com.darkbit.sample.specification.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profile")
@Slf4j
public class ProfileController {


    @Autowired
    ProfileRepository profileRepository;

    @GetMapping
    public Page<Profile> getProfiles(@PageableDefault Pageable pageable,
                                     @RequestParam(name = "search", required = false)String search){

        log.info("search query : " + search);


        if(!StringUtils.isEmpty(search)){
            Node rootNode = new RSQLParser().parse(search);
            Specification<Profile> spec = rootNode.accept(new CustomRsqlVisitor<Profile>());
            return  profileRepository.findAll(spec,pageable);
        }else{
            return  profileRepository.findAll(pageable);
        }

    }
}
