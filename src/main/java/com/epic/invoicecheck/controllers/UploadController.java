package com.epic.invoicecheck.controllers;

import com.epic.invoicecheck.entity.DeliveryInfo;
import com.epic.invoicecheck.models.UploadForm;
import com.epic.invoicecheck.models.UploadMessage;
import com.epic.invoicecheck.repository.DeliveryInfoRepository;
import com.epic.invoicecheck.repository.DifferentsRepository;
import com.epic.invoicecheck.services.CheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
@RequestMapping("/uploadform")
@Slf4j
@AllArgsConstructor
public class UploadController {

    private final DifferentsRepository differentsRepository;
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final CheckService checkService;


    @GetMapping
    public String upload(Model model){
        model.addAttribute("uploadform", new UploadForm());
        model.addAttribute("msg", new UploadMessage());
        return "uploadform";
    }

    @PostMapping
    public Object postUpload(@RequestParam("file") MultipartFile file, @ModelAttribute UploadForm uploadForm, Model model) throws IOException, JRException {
        if (checkService.startChecking(file, uploadForm).isEmpty()) {
            model.addAttribute("uploadform", new UploadForm());
            model.addAttribute("msg", new UploadMessage("No difference between order and invoice"));
            return "uploadform";
        } else {
            DeliveryInfo delInfo = deliveryInfoRepository.findByOrderNrAndSupplireNr(uploadForm.getOrderNr(), uploadForm.getSupplireNr());
            RedirectView redirectView = new RedirectView();
            log.info("redirect");
            redirectView.setUrl("/invoicecheck/report/" + delInfo.getDeliveryId());
//            redirectView.setUrl("/report/" + delInfo.getDeliveryId());
            log.info(redirectView.getUrl());
            log.info("set url");
            return redirectView;
        }
    }


}
