package app.appenders;

import app.enums.ReportLevel;

public interface Appender {
    void append(String dateTime, ReportLevel reportLevel,String message);
    boolean checkIfReportLevelISValid(ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);

}
