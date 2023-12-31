// Generated by view binder compiler. Do not edit!
package org.tensorflow.lite.examples.objectdetection.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.tensorflow.lite.examples.objectdetection.R;

public final class ActivityTestBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView accelerationTextView;

  @NonNull
  public final TextView resultTextView;

  private ActivityTestBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView accelerationTextView, @NonNull TextView resultTextView) {
    this.rootView = rootView;
    this.accelerationTextView = accelerationTextView;
    this.resultTextView = resultTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_test, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTestBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accelerationTextView;
      TextView accelerationTextView = ViewBindings.findChildViewById(rootView, id);
      if (accelerationTextView == null) {
        break missingId;
      }

      id = R.id.resultTextView;
      TextView resultTextView = ViewBindings.findChildViewById(rootView, id);
      if (resultTextView == null) {
        break missingId;
      }

      return new ActivityTestBinding((RelativeLayout) rootView, accelerationTextView,
          resultTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
