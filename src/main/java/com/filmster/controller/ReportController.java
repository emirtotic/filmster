package com.filmster.controller;

import com.filmster.service.MovieService;
import com.filmster.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
@Validated
@Tag(name = "04 Report")
public class ReportController {

    private final MovieService movieService;
    private final ReportService reportService;

    @Operation(summary = "Create Movie Report", description = "Creating PDF Jasper Report for the movie")
    @GetMapping("/pdf/{movieId}")
    public ResponseEntity<String> createGeneralPdfMovieReport(@PathVariable(name = "movieId") Long id, final HttpServletResponse response) throws IOException {

        InputStream inputStream = reportService.createGeneralPdfReport(id);

        if (inputStream != null) {
            String generatedFileName = "MovieReport.pdf";
            response.setContentType(URLConnection.guessContentTypeFromName(generatedFileName));
            response.setHeader("Content-Disposition", "attachment; filename=" + generatedFileName);

            try {
                final ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create Movie Report EXCEL", description = "Creating PDF Jasper Report for the movie EXCEL")
    @GetMapping("/excel")
    public ResponseEntity<String> createGeneralExcelMovieReport(final HttpServletResponse response) throws IOException {

        InputStream inputStream = reportService.createGeneralExcelReport();

        if (inputStream != null) {
            String generatedFileName = "MoviesReport.xlsx";
            response.setContentType(URLConnection.guessContentTypeFromName(generatedFileName));
            response.setHeader("Content-Disposition", "attachment; filename=" + generatedFileName);

            try {
                final ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
