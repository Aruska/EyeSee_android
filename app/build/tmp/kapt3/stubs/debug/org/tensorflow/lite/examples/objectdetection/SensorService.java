package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0002JKB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J \u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u001dH\u0002J\u0006\u00105\u001a\u00020,J\u0018\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0014\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020,H\u0016J\b\u0010A\u001a\u00020,H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u001dH\u0016J\"\u0010D\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0005H\u0016J\u000e\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020IR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/SensorService;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "()V", "PERIODIC_EVENT_TIMEOUT", "", "accMagOrientation", "", "accel", "degreeFloat", "", "degreeFloat2", "doPeriodicTask", "Ljava/lang/Runnable;", "fuseTimer", "Ljava/util/Timer;", "fusedOrientation", "gyro", "gyroMatrix", "gyroOrientation", "handler", "Landroid/os/Handler;", "initState", "", "latitude", "", "longitude", "mPeriodicEventHandler", "mSensorEvent", "Landroid/hardware/SensorEvent;", "magnet", "rotationMatrix", "senAccelerometer", "Landroid/hardware/Sensor;", "senProximity", "senSensorManager", "Landroid/hardware/SensorManager;", "sendCount", "sentRecently", "", "timestamp", "tts", "Landroid/speech/tts/TextToSpeech;", "calculateAccMagOrientation", "", "getRotationMatrixFromOrientation", "o", "getRotationVectorFromGyro", "gyroValues", "deltaRotationVector", "timeFactor", "gyroFunction", "event", "initListeners", "matrixMultiplication", "A", "B", "onAccuracyChanged", "sensor", "i", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onSensorChanged", "sensorEvent", "onStartCommand", "flags", "startId", "speak", "text", "", "CalculateFusedOrientationTask", "Companion", "app_debug"})
public final class SensorService extends android.app.Service implements android.hardware.SensorEventListener {
    private android.speech.tts.TextToSpeech tts;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private final android.os.Handler handler = null;
    private final android.os.Handler mPeriodicEventHandler = null;
    private final int PERIODIC_EVENT_TIMEOUT = 3000;
    private final java.util.Timer fuseTimer = null;
    private int sendCount = 0;
    private char sentRecently = 'N';
    private final float[] gyro = null;
    private float degreeFloat = 0.0F;
    private float degreeFloat2 = 0.0F;
    private float[] gyroMatrix;
    private final float[] gyroOrientation = null;
    private final float[] magnet = null;
    private final float[] accel = null;
    private final float[] accMagOrientation = null;
    private final float[] fusedOrientation = null;
    private final float[] rotationMatrix = null;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.objectdetection.SensorService.Companion Companion = null;
    public static final float EPSILON = 1.0E-9F;
    public static final int TIME_CONSTANT = 30;
    public static final float FILTER_COEFFICIENT = 0.98F;
    private static final float NS2S = 1.0E-9F;
    private float timestamp = 0.0F;
    private boolean initState = true;
    private android.hardware.SensorManager senSensorManager;
    private android.hardware.Sensor senAccelerometer;
    private android.hardware.Sensor senProximity;
    private android.hardware.SensorEvent mSensorEvent;
    private final java.lang.Runnable doPeriodicTask = null;
    
    public SensorService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    public final void speak(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    public final void initListeners() {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.NotNull
    android.hardware.SensorEvent sensorEvent) {
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.NotNull
    android.hardware.Sensor sensor, int i) {
    }
    
    public final void calculateAccMagOrientation() {
    }
    
    private final void getRotationVectorFromGyro(float[] gyroValues, float[] deltaRotationVector, float timeFactor) {
    }
    
    private final void gyroFunction(android.hardware.SensorEvent event) {
    }
    
    private final float[] getRotationMatrixFromOrientation(float[] o) {
        return null;
    }
    
    private final float[] matrixMultiplication(float[] A, float[] B) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/SensorService$CalculateFusedOrientationTask;", "Ljava/util/TimerTask;", "(Lorg/tensorflow/lite/examples/objectdetection/SensorService;)V", "run", "", "app_debug"})
    public final class CalculateFusedOrientationTask extends java.util.TimerTask {
        
        public CalculateFusedOrientationTask() {
            super();
        }
        
        @java.lang.Override
        public void run() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/SensorService$Companion;", "", "()V", "EPSILON", "", "FILTER_COEFFICIENT", "NS2S", "TIME_CONSTANT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}