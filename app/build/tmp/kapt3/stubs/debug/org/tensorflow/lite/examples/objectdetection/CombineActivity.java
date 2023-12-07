package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/CombineActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accelerationTextView", "Landroid/widget/TextView;", "activityMainBinding", "Lorg/tensorflow/lite/examples/objectdetection/databinding/ActivityMainBinding;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "dangerFab", "Landroid/view/View;", "delayMillis", "", "gyroscopeTextView", "handler", "Landroid/os/Handler;", "popupHandler", "tts", "Landroid/speech/tts/TextToSpeech;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "registerBroadcastReceiver", "showDangerPopup", "speak", "text", "", "app_debug"})
public final class CombineActivity extends androidx.appcompat.app.AppCompatActivity {
    private org.tensorflow.lite.examples.objectdetection.databinding.ActivityMainBinding activityMainBinding;
    private android.content.BroadcastReceiver broadcastReceiver;
    private android.widget.TextView accelerationTextView;
    private android.widget.TextView gyroscopeTextView;
    private android.view.View dangerFab;
    private android.os.Handler handler;
    private android.os.Handler popupHandler;
    private android.speech.tts.TextToSpeech tts;
    private final long delayMillis = 5000L;
    
    public CombineActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void registerBroadcastReceiver() {
    }
    
    public final void speak(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void showDangerPopup() {
    }
}