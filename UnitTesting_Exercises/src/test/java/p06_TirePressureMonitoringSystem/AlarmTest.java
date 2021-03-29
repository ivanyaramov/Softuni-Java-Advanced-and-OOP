package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    @Test
    public void testWhenLowerThanLowPressureThreshold(){
Sensor sensor= Mockito.mock(Sensor.class);
Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.5);
Alarm alarm=new Alarm(sensor);
alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testWhenLowerThanHighPressureThreshold(){
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(80.);
        Alarm alarm=new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testWhenNormalPressureThenAlarmOff(){
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.);
        Alarm alarm=new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}
