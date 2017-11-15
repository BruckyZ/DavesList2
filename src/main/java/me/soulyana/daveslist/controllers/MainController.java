package me.soulyana.daveslist.controllers;

import me.soulyana.daveslist.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/")
    public String listRooms(Model model)
    {
        model.addAttribute("rooms", roomRepository.findAll());
        return "list";
    }

    
}
