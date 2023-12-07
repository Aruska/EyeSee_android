package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MenuActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "tts", "Landroid/speech/tts/TextToSpeech;", "navigateToMainActivity", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "speak", "text", "", "Companion", "app_debug"})
public final class MenuActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.speech.tts.TextToSpeech tts;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion Companion = null;
    private static final java.lang.String PERMISSION_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    private static final java.lang.String PERMISSION_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    private static final int PERMISSIONS_REQUEST = 1;
    
    public MenuActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navigateToMainActivity() {
    }
    
    public final void speak(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MenuActivity$Companion;", "", "()V", "PERMISSIONS_REQUEST", "", "PERMISSION_COARSE_LOCATION", "", "PERMISSION_FINE_LOCATION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}