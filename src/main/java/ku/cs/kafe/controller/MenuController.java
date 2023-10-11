// Jirapa Wongsuwon 6410450761
package ku.cs.kafe.controller;


import ku.cs.kafe.entity.Menu;
import ku.cs.kafe.model.MenuRequest;
import ku.cs.kafe.service.CategoryService;
import ku.cs.kafe.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllMenus(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "menu-all";
    }

    @GetMapping("/{id}")
    public String getOneMenu(@PathVariable UUID id, Model model) {
        Menu menu = menuService.getOneById(id);
        model.addAttribute("menu", menu);
        return "menu-view";
    }

    @GetMapping("/add")
    public String getMenuForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "menu-add";
    }

    @PostMapping("/add")
    public String createMenu(@ModelAttribute MenuRequest menu, Model model) {
        menuService.createMenu(menu);
        model.addAttribute("menus", menuService.getAllMenus());
        return "redirect:/menus";
    }
}
