package ru.volodin.SortXLSX.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

@Service
public class XlsxServiceImpl implements XlsxService {

    @Override
    public Integer getMaxValueFromXlsx(MultipartFile file, int n) {

        if (n >= 0) {
            TreeSet<Integer> numbers = new TreeSet<>();

            try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    Cell cell = row.getCell(0);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        numbers.add((int) cell.getNumericCellValue());
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException("Ошибка чтения файла Excel", e);
            }

            return new ArrayList<>(numbers).get(n);

        } else {
            throw new IllegalArgumentException("Неверно указан аргумент n");
        }
    }
}
