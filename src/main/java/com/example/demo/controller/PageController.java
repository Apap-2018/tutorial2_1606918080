package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class PageController {
    @RequestMapping("/challenge/{name}")
    public String challengePath(@PathVariable String name, Model model){
        model.addAttribute("name",name);
        return "challenge";
    }

    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/viral/challange")
    public String challlenge(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping("/generator")
    public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model){
        Integer NilaiA = Integer.parseInt(a);
        Integer NilaiB = Integer.parseInt(b);
        String output = "";

        if (NilaiB<=1){
            output+=" h";
            if (NilaiA<=1){
                output+="m";
                model.addAttribute("hasil", output.substring(1));
            }
            else for (int y = 0; y<NilaiA; y++){
                output+="m";
            }
            model.addAttribute("hasil", output.substring(1));
        }
        else for (int x = 0; x < NilaiB; x++){
            output+=" h";
            if (NilaiA<=1){
                output+="m";
                model.addAttribute("hasil", output.substring(1));
            }
            else for (int y = 0; y<NilaiA; y++){
                output+="m";
            }
            model.addAttribute("hasil", output.substring(1));
        }
        model.addAttribute("a", NilaiA);
        model.addAttribute("b", NilaiB);
        return "viralGenerator";
    }

}
