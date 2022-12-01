package com.exercise.validate_info_the_song.controller;

import com.exercise.validate_info_the_song.dto.SongDto;
import com.exercise.validate_info_the_song.model.Song;
import com.exercise.validate_info_the_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @RequestMapping("")
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "song/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        return "song/create";
    }

    @PostMapping("/save")
    public String saveSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "song/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Add new success");
            return "redirect:/song";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model){
        Optional<Song> song = songService.findById(id);
        SongDto songDto = new SongDto();
        if(song.isPresent()){
            BeanUtils.copyProperties(song.get(), songDto);
            model.addAttribute("songDto", songDto);
            return "/song/edit";
        }else {
            return "/error-404";
        }
    }

    @PostMapping("/update")
    public String updateSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "/song/edit";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Edit success");
            return "redirect:/song";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        songService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/song";
    }

}
