package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.TryMybatisGenerator;
import com.example.demo.mapper.TryMybatisGeneratorMapper;

@Controller
public class TryMybatisController {

    @Autowired
    TryMybatisGeneratorMapper tmgMapper;

    @RequestMapping("/")
    public String index(Model model) {
    	TryMybatisGenerator tmg = tmgMapper.selectByPrimaryKey(Long.parseLong("1"));
        model.addAttribute("column1", tmg.getColumn1());
        model.addAttribute("column2", tmg.getColumn2());
        model.addAttribute("column3", tmg.getColumn3());
        return "index";
    }

}
