package com.filmster.service.impl;

import com.filmster.entity.Movie;
import com.filmster.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class ExcelServiceImpl implements ExcelService {

    @Override
    @Transactional(readOnly = true)
    public InputStream exportToExcel(List<Movie> movies) {

        try {

            //create workbook in xlsx format
            Workbook workbook = new HSSFWorkbook();

            //For .xsl workbooks use new HSSFWorkbook()
            Sheet sh = workbook.createSheet("Movies");

            // Create top row with column headings
            String[] columnHeadings = {"ID", "Name", "Director", "Year", "Popularity", "Description"};

            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.WHITE.getIndex());

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

            Row headerRow = sh.createRow(0);

            for (int i = 0; i < columnHeadings.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }

            CreationHelper creationHelper = workbook.getCreationHelper();
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));

            int rowNum = 1;

            for (Movie i : movies) {
                Row row = sh.createRow(rowNum++);
                row.createCell(0).setCellValue(i.getId());
                row.createCell(1).setCellValue(i.getName());
                row.createCell(2).setCellValue(i.getDirector());
                row.createCell(3).setCellValue(i.getYear());
                row.createCell(4).setCellValue(i.getPopularity().getCode());
                row.createCell(5).setCellValue(i.getDescription());
            }

            // Autosize columns
            for (int i = 0; i < columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            workbook.write(baos);
            byte[] bytes = baos.toByteArray();

            InputStream inputStream = new ByteArrayInputStream(bytes);
            return inputStream;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
