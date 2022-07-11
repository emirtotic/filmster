package com.filmster.service;

import com.filmster.entity.Movie;

import java.io.InputStream;
import java.util.List;

public interface ExcelService {

    InputStream exportToExcel(List<Movie> movies);
}
