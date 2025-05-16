package ru.volodin.SortXLSX.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public interface XlsxService {
    Integer getMaxValueFromXlsx(MultipartFile file, int n) throws FileNotFoundException;
}
