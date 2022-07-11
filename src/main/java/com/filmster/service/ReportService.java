package com.filmster.service;

import java.io.InputStream;

public interface ReportService {

    /**
     * Create overall PDF movie report
     * @param id
     * @return InputStream for creating pdf report
     */
    InputStream createGeneralPdfReport(Long id);

    /**
     * Create all movies report
     *
     * @return InputStream for creating excel .xlsx report
     */
    InputStream createGeneralExcelReport();

}
