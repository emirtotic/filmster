package com.filmster.service.impl;

import com.filmster.dto.MovieDTO;
import com.filmster.entity.Movie;
import com.filmster.mapper.MovieMapper;
import com.filmster.service.ExcelService;
import com.filmster.service.JasperService;
import com.filmster.service.MovieService;
import com.filmster.service.ReportService;
import com.filmster.service.report.MovieReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final MovieService movieService;
    private final JasperService jasperService;
    private final ExcelService excelService;
    private final MovieMapper movieMapper;


    /**
     * Create overall movie report
     *
     * @param id
     * @return InputStream for creating pdf report
     */
    @Override
    @Transactional(readOnly = true)
    public InputStream createGeneralPdfReport(Long id) {

        Map<String, Object> params = new HashMap<>();
        MovieReport movieReport = prepareDataForMovieReport(id);
        params.put("movieReport", movieReport);

        return jasperService.exportReportToPDF("/report/movie-report.jrxml", params, null);
    }

    /**
     * Create all movies report
     *
     * @return InputStream for creating excel .xlsx report
     */
    @Override
    public InputStream createGeneralExcelReport() {

        List<Movie> movies = movieMapper.mapToMoviesList(movieService.findAllMovies());
        return excelService.exportToExcel(movies);
    }


    public MovieReport prepareDataForMovieReport(Long movieId) {

        MovieReport movieReport = new MovieReport();
        MovieDTO movieDTO = movieService.findMovieById(movieId);

        List<String> genre = new ArrayList<>();
        List<String> actors = new ArrayList<>();
        movieDTO.getGenre().forEach(gen -> genre.add(gen.getName()));
        movieDTO.getActors().forEach(actor -> actors.add(actor.getFirstName() + " " + actor.getLastName()));


        movieReport.setMovieName(movieDTO.getName());
        movieReport.setDescription(movieDTO.getDescription());
        movieReport.setDirector(movieDTO.getDirector());
        movieReport.setYear(movieDTO.getYear());
        movieReport.setPopularity(movieDTO.getPopularity().getCode());
        movieReport.setGenre(genre);
        movieReport.setActors(actors);

        return movieReport;
    }
}
