package app.appenders;

import app.enums.ReportLevel;
import app.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }

    public BaseAppender(Layout layout) {
        this.messagesAppended=0;
        this.layout = layout;
    }
    @Override
    public boolean checkIfReportLevelISValid(ReportLevel reportLevel){
        return this.getReportLevel().ordinal()<=reportLevel.ordinal();
    }

    public int getMessagesAppended() {
        return messagesAppended;
    }

    public void setMessagesAppended(int messagesAppended) {
        this.messagesAppended = messagesAppended;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d.",this.getClass().getSimpleName(),this.layout.getClass().getSimpleName(),
                this.getReportLevel(),this.getMessagesAppended());
    }
}
