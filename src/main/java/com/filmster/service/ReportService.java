package com.filmster.service;

import java.io.InputStream;

public interface ReportService {

    /**
     * Create overall movie report
     * @param id
     * @return InputStream for creating pdf report
     */
    InputStream createGeneralReport(Long id);

}
