package homework_6.task_5;


public class Holidays {
    private String dateHoliday;
    private String nameHoliday;
    private String typeHoliday;


    public Holidays(String dateHoliday, String nameHoliday, String typeHoliday) {
        this.dateHoliday = dateHoliday;
        this.nameHoliday = nameHoliday;
        this.typeHoliday = typeHoliday;
    }


    public String getDateHoliday() {
        return dateHoliday;
    }

    public void setDateHoliday(String dateHoliday) {
        this.dateHoliday = dateHoliday;
    }

    public String getNameHoliday() {
        return nameHoliday;
    }

    public void setNameHoliday(String nameHoliday) {
        this.nameHoliday = nameHoliday;
    }

    public String getTypeHoliday() {
        return typeHoliday;
    }

    public void setTypeHoliday(String typeHoliday) {
        this.typeHoliday = typeHoliday;
    }
}
