package me.soulyana.daveslist.controllers;

import me.soulyana.daveslist.entities.Room;
import me.soulyana.daveslist.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class MainController
{
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/")
    public String publiclistRooms(Model model)
    {
        model.addAttribute("rooms", roomRepository.findAll());
        return "list";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }


    @RequestMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    @GetMapping("/register")   //new user registring page
    public String roomform(Model model)
    {
        model.addAttribute("room", new Room());
        return "register";
    }

    @GetMapping("/add")   //admin to add new listing
    public String addlisting(Model model)
    {
        model.addAttribute("rooms", new Room());
        return "roomform";
    }


    @PostMapping("/process")
    public String roomprocess(@Valid Room room, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "roomform";
        }
        roomRepository.save(room);
        return "redirect/";
    }

       @RequestMapping("/detail/{id}")
    public String showrooms(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("room", roomRepository.findOne(id));
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updaterooms(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("room", roomRepository.findOne(id));
        return "roomform";
    }

}

