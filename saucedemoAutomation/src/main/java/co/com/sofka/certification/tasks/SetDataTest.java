package co.com.sofka.certification.tasks;

import co.com.sofka.certification.models.DataExcel;
import co.com.sofka.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.sofka.certification.utils.Constants.DATA_TEST;

public class SetDataTest implements Task {

    private final String sheet;
    private final String idTest;

    public SetDataTest(String sheet, String idTest){
        this.sheet = sheet;
        this.idTest = idTest;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DataExcel dataExcel = new DataExcel();
        dataExcel.setSetDeDatos(SetData.fromExcel(sheet, idTest));
        actor.remember(DATA_TEST, dataExcel);
    }
    public static SetDataTest user(String sheet, String idTest){
        return Tasks.instrumented(SetDataTest.class, sheet, idTest);
    }
}