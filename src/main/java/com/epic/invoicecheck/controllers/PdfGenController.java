package com.epic.invoicecheck.controllers;

import com.epic.invoicecheck.entity.DiffReport;
import com.epic.invoicecheck.models.PdfModel;
import com.epic.invoicecheck.repository.DiffReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class PdfGenController {
    @Autowired
    private DiffReportRepository diffReportRepository;


    @RequestMapping(path = "/report/{deliveri}", method = RequestMethod.GET)
    public Object report(@PathVariable String deliveri) throws IOException {
        Map<String, Object> model = new HashMap<>();

        List<DiffReport> cars = diffReportRepository.findByDeliveryId(deliveri);

        model.put("cars", cars);

        return new ModelAndView(new PdfModel(), model);
    }
}