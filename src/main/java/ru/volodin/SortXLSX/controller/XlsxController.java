package ru.volodin.SortXLSX.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.volodin.SortXLSX.service.XlsxService;

@RestController
@RequestMapping("/sort")
public class XlsxController {

    @Autowired
    private XlsxService xlsxService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getMaxValueFromXlsx(@RequestParam("file") MultipartFile file, @RequestParam int n){
        try {
            return ResponseEntity.ok(xlsxService.getMaxValueFromXlsx(file, n));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
