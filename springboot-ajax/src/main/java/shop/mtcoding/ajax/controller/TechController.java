package shop.mtcoding.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.ajax.dto.TechResponse;
import shop.mtcoding.ajax.model.Category;
import shop.mtcoding.ajax.model.CategoryRepository;
import shop.mtcoding.ajax.model.Tech;
import shop.mtcoding.ajax.model.TechRepository;

@Controller
public class TechController {

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/test/tech")
    public @ResponseBody TechResponse.MainDTO tech() {
        List<Category> categoryList = categoryRepository.findAll();
        List<Tech> techList = techRepository.findByCategoryId(1);
        System.out.println("=================================");
        TechResponse.MainDTO mainDTO = new TechResponse.MainDTO(categoryList, techList);
        return mainDTO; // messageconverter 발동 - json 변환
    }

    @GetMapping("/tech")
    public String tech(Model model) {
        List<Tech> techList = techRepository.findAll();
        model.addAttribute("techList", techList);
        return "main";
    }
}
